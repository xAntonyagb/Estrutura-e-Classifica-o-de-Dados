package br.unipar.SysContasBancarias.models;

import br.unipar.SysContasBancarias.enums.TipoMetodologiaPesquisaEnum;
import br.unipar.SysContasBancarias.enums.TipoPesquisaEnum;
import br.unipar.SysContasBancarias.enums.TipoTransferenciaEnum;
import br.unipar.SysContasBancarias.exceptions.ContaExistenteException;
import br.unipar.SysContasBancarias.exceptions.ContasNaoCriadasException;
import br.unipar.SysContasBancarias.exceptions.SaldoNegativoException;
import static br.unipar.SysContasBancarias.services.BancoService.validaNovaConta;
import br.unipar.SysContasBancarias.services.ContaService;
import br.unipar.SysContasBancarias.services.TransferenciaService;
import br.unipar.SysContasBancarias.utils.OrdenacaoLinearUtils;
import br.unipar.SysContasBancarias.utils.PesquisaBinariaUtils;
import static br.unipar.SysContasBancarias.utils.PesquisaLinearUtils.pesquisar;
import javax.swing.JOptionPane;

public class Banco {
    private Conta[] contas;
    private String cnpj;
    private String nome;
    private String telefone;
    private Endereco endereco;

    public Banco(String cnpj, String nome, String telefone, Endereco endereco) {
        contas = new Conta[0];
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Banco() {
        contas = new Conta[0];
    }

    public Conta[] getContas() {
        return contas;
    }

    public void addConta(Conta c) {
        boolean adicionar = false;
        
        //Testar se a conta criada tem número de conta repetido antes de adicionar
        try{
            validaNovaConta(this, c);
            adicionar = true;
        } catch (ContaExistenteException ex) {
            //Escolher adicionar mesmo assim
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, ex.getMessage() + "\nGostaria de adiciona-la do mesmo jeito?",
                    "Adicionar conta repetida",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            
            adicionar = escolha == 0;
        }
        
        //Se for adicionar
        if(adicionar) {
            Conta[] aux = contas.clone();
            contas = new Conta[contas.length+1];
            System.arraycopy(aux, 0, contas, 0, aux.length);

            contas[contas.length-1] = c;
        }
    }
    
    
    public String imprimirContasNumero() {
        Conta[] contasOrdenadas = OrdenacaoLinearUtils.ordenarContasNum(contas);
        String output = "";
        
        for(Conta c : contasOrdenadas){
            output += c + "\n\n";
        }
        
        return output;
    }
    
    public String imprimirContasSaldo() {
        Conta[] contasOrdenadas = OrdenacaoLinearUtils.ordenarContasSaldo(contas);
        String output = "";
        
        for(Conta c : contasOrdenadas){
            output += c + "\n\n";
        }
        
        return output;
    }
    
    //Metodo por número
    public Conta pesquisarContaBanco(TipoPesquisaEnum tipoPesq) {
        try{
            //Tratamento caso nenhuma conta tenha sida criada ainda
            if(contas.length == 0)
                throw new ContasNaoCriadasException();


            Conta[] output = new Conta[1];
            
            //Caso o metodo de pesquisa seja Linear
            if(tipoPesq.equals(TipoPesquisaEnum.LINEAR)){
                
                
                //Escolher o tipo da metodologia da pesquisa
                String[] opcoeseTipoMetodologia = {"Número da conta", "Nome do destinatário"};

                int escolhaTipoMetodologia = JOptionPane.showOptionDialog(null, "Como deseja procurar a conta:",
                        "Modo da pesquisa",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoeseTipoMetodologia, opcoeseTipoMetodologia[0]);

                
                if(escolhaTipoMetodologia == 0)
                    //Caso a pesquisa seja por número de conta
                    output = pesquisar(contas, TipoMetodologiaPesquisaEnum.NUMERO);
                
                else
                    //Caso seja por titular da conta
                    output = pesquisar(contas, TipoMetodologiaPesquisaEnum.TITULAR);
            }
                
            //Caso o metodo de pesquisa seja Binaria
            else
                output[0] = PesquisaBinariaUtils.pesquisarConta(contas);


            //Mostrar opções da pesquisa
            String[] opcoesOut = new String[output.length+1];
            
            String msg;
            String titulo;
            
            //Se não for encontrada nenhuma conta
            if(output.length == 0) {
                msg = "Nenhuma conta assim foi encontrada. Tente novamente \n(Contas disponiveis podem ser vistas no console)";
                titulo = "Conta inexistente";
                System.out.println("Contas disponiveis:\n" + imprimirContasNumero());
            }
            //Se for
            else {
                msg = "As seguintes contas foram encontradas.\nSelecione a conta que deseja depositar:";
                titulo = "Seleção de deposito";
            }

            //Opções
            opcoesOut[0] = "Procurar novamente";

            for(int i = 1; i <= output.length; i++) {
                opcoesOut[i] = "Conta " + output[i-1].getNumeroConta() + " | " + output[i-1].getTitular().getNome();
            }

            int escolhaDeposito = JOptionPane.showOptionDialog(null, msg,
                                titulo,
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesOut, opcoesOut[0]);


            //Retorno da conta
            if(escolhaDeposito == 0) {
                return pesquisarContaBanco(tipoPesq);
            } else {
                return output[escolhaDeposito-1];
            }

        } catch (ContasNaoCriadasException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            //Criar a conta
            ContaService cServ = new ContaService();
            Conta c = cServ.criarConta();
            addConta(c);
            
            return c;
        }
    }
    
    public double getTotalSaldos() {
        //Validar saldos negativos
        try{
            verificarSaldosNegativos();
        } catch (SaldoNegativoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            //Escolher arrumar saldos negativos
            String[] opcoesDivida = {"Sim", "Não"};

            int escolhaDivida = JOptionPane.showOptionDialog(null, "Gostaria de pagar as dividas de todas as contas?",
                    "Arrumar contas com saldos negativos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesDivida, opcoesDivida[0]);
            
            
            //Sim
            if(escolhaDivida == 0){
                Conta[] cNegativas = getContasNegativas();
                String msg = "Dividas pagas nas contas:\n\n";
                
                for(Conta c : cNegativas){
                    
                    double valorDivida = (- c.getSaldoTransferencias());
                    
                    //Fazendo deposito para pagar a divida
                    Transferencia transfDivida = new Transferencia();
                    transfDivida.setValor(valorDivida);
                    transfDivida.setTipo(TipoTransferenciaEnum.ENTRADA);
                    
                    c.addTransferencia(transfDivida);
                    
                    //Botando na msg
                    msg += "Conta " + c.getNumeroConta() 
                            + " | Titular: " + c.getTitular().getNome()
                            + "\nValor em dividas pago: " + valorDivida + "\n";
                }
                
                //Mostrando para o usuário
                JOptionPane.showMessageDialog(null, msg);
            }  
        }
        
        //Somar saldo das contas
        return somarSaldoContas(contas.length-1);
    }
    
    private double somarSaldoContas(int i) {
        double saldo = contas[i].getSaldoTransferencias();
        
        if (i == 0) {
            return saldo;
        }
       
        return saldo + somarSaldoContas(--i);
    }
    
    public void verificarSaldosNegativos() throws SaldoNegativoException {
        String msgContas = "";
        boolean contaNegativa = false;
        
        for(Conta c : contas) {
            double saldoTransf = c.getSaldoTransferencias();
            
            if(saldoTransf < 0) {
                contaNegativa = true;
                msgContas += "Conta: " + c.getNumeroConta()
                        + " | Titular: " + c.getTitular().getNome()
                        + "\nSaldo: " + saldoTransf + "\n";
            }
        }
        
        if(contaNegativa) {
            throw new SaldoNegativoException(msgContas);
        }
    }
    
    public Conta[] getContasNegativas() {
        Conta[] contasNegativas = new Conta[0];
        
        for(Conta c : contas) {
            double saldo = c.getSaldoTransferencias();
            
            if(saldo < 0) {
                Conta[] aux = contasNegativas.clone();
                contasNegativas = new Conta[contasNegativas.length+1];
                System.arraycopy(aux, 0, contasNegativas, 0, aux.length);

                contasNegativas[contasNegativas.length-1] = c;
            }
        }
        return contasNegativas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Banco{" + "Contas=" + imprimirContasNumero() + ", cnpj=" + cnpj + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
}
