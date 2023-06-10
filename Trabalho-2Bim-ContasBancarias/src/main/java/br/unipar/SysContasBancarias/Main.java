package br.unipar.SysContasBancarias;

import br.unipar.SysContasBancarias.enums.TipoPesquisaEnum;
import br.unipar.SysContasBancarias.models.Banco;
import br.unipar.SysContasBancarias.models.Cidade;
import br.unipar.SysContasBancarias.models.Conta;
import br.unipar.SysContasBancarias.models.Endereco;
import br.unipar.SysContasBancarias.models.Estado;
import br.unipar.SysContasBancarias.models.Pais;
import br.unipar.SysContasBancarias.models.Pessoa;
import br.unipar.SysContasBancarias.models.Transferencia;
import br.unipar.SysContasBancarias.services.ContaService;
import br.unipar.SysContasBancarias.services.TransferenciaService;
import br.unipar.SysContasBancarias.utils.ListagemCidadesUtils;
import br.unipar.SysContasBancarias.utils.ListagemEstadosUtils;
import br.unipar.SysContasBancarias.utils.ListagemPaisesUtils;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        //Instanciando objetos para melhor execução do trabalho
        Banco b = new Banco();
        
        Conta c = new Conta();
        c.setNumeroConta(848);
        c.setSaldoInicial(100);
        
        b.addConta(c);

        Pessoa p = new Pessoa();
        p.setNome("Antony");
        p.setCpf("123.123.123-12");
        p.setDataNascimento("30/12/2004");
        p.setRg("123456789");
        p.setTelefone("45988248206");
        
        c.setTitular(p);
        
        Endereco end = new Endereco();
        end.setBairro("Bairo Frederico Rodrigues");
        end.setCep("12312-123");
        end.setComplemento("apartamento");
        end.setLongradouro("Rua da Faculdade");
        end.setNumero(123);
        
        p.setEndereco(end);
        
        Cidade toledo = new Cidade();
        toledo.setNome("Toledo");
        toledo.setSigla("TOO");
        
        end.setCidade(toledo);
        
        Estado parana = new Estado();
        parana.setNome("Paraná");
        parana.setSigla("PR");
        
        toledo.setEstado(parana);
        
        Cidade cascavel = new Cidade();
        cascavel.setNome("Cascavel");
        cascavel.setSigla("CAC");
        cascavel.setEstado(parana);
        
        Pais brasil = new Pais();
        brasil.setNome("Brasil");
        brasil.setSigla("BR");
        
        parana.setPais(brasil);

        b.setCnpj("123456789123");
        b.setEndereco(end);
        b.setNome("Banco do Brasil");
        b.setTelefone("45993456892");
        
        ListagemPaisesUtils.addPais(brasil);
        ListagemEstadosUtils.addEstado(parana);
        ListagemCidadesUtils.addCidade(toledo);
        ListagemCidadesUtils.addCidade(cascavel);

        int escolha;
        do{
            //Menu de escolha
            String[] opcoes = {"Cadastrar nova conta", "Mostrar contas", "Depositar", "Sacar", "Calcular saldo total do banco", "Fechar sistema"};
            escolha = JOptionPane.showOptionDialog(null, "Escolha que operação deseja fazer:",
                    "Menu de escolhas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);


            //Instanciando o service de transferencia
            TransferenciaService tServ = new TransferenciaService();
            
            switch(escolha) {
                //Cadastrar nova conta
                case 0:
                    ContaService contaServ = new ContaService();
                    b.addConta(contaServ.criarConta());

                    break;

                //Mostrar contas
                case 1:
                    String[] opcoesOrdenacao = {"Número da conta", "Saldo"};

                    int escolhaOrdenacao = JOptionPane.showOptionDialog(null, "Por que maneira deseja exibir as contas:",
                            "Modo da ordenação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesOrdenacao, opcoesOrdenacao [0]);
                    

                    //Se é por número da conta
                    if(escolhaOrdenacao == 0){
                        JOptionPane.showMessageDialog(null, b.imprimirContasNumero());
                    }
                    //Se é por saldo
                    else{
                        JOptionPane.showMessageDialog(null, b.imprimirContasSaldo());
                    }


                    break;

                //Depositar
                case 2:
                    //Pesquisar
                    Conta contaDeposito = b.pesquisarContaBanco(TipoPesquisaEnum.LINEAR);
                    
                    //Fazer o deposito
                    Transferencia transfDeposito = tServ.criarDeposito();
                    contaDeposito.addTransferencia(transfDeposito);
                    
                    JOptionPane.showMessageDialog(null, "Transferencia realizada com suscesso!\n"
                            + "Conta = " + contaDeposito.getNumeroConta() 
                            + ", Titular = " + contaDeposito.getTitular().getNome()
                            + "\n" + transfDeposito.toString(), "Extrato", 1);
                    
                    break;


                //Sacar
                case 3:
                    //Pesquisar
                    Conta contaSaque = b.pesquisarContaBanco(TipoPesquisaEnum.BINARIA);
                    
                    //Fazer o saque
                    Transferencia transfSaque = tServ.criarSaque();
                    contaSaque.addTransferencia(transfSaque);
                    
                    JOptionPane.showMessageDialog(null, "Transferencia realizada com suscesso!\n"
                            + "Conta = " + contaSaque.getNumeroConta() 
                            + ", Titular = " + contaSaque.getTitular().getNome()
                            + "\n" + transfSaque.toString(), "Extrato", 1);
                    break;


                //Calcular saldo total do banco e conferir se existem saldos negativos
                case 4:
                    JOptionPane.showMessageDialog(null, "O banco possui saldo total de: " + b.getTotalSaldos());
                    break;  
            }
        } while (escolha != 5);
        
    }
}
