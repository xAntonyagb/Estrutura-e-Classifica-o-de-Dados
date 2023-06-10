package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.enums.TipoMetodologiaPesquisaEnum;
import br.unipar.SysContasBancarias.exceptions.PesquisaNaoSucedidaException;
import br.unipar.SysContasBancarias.models.Conta;
import br.unipar.SysContasBancarias.services.JOptionPaneService;
import javax.swing.JOptionPane;

public class PesquisaLinearUtils {

    public static Conta[] pesquisar(Conta[] vetC, TipoMetodologiaPesquisaEnum tipo){
        //Tratamento caso não ache na pesquisa
        try{
            
            Conta[] vetOrdenado = OrdenacaoLinearUtils.ordenarContasNum(vetC);
            Conta[] output = new Conta[0];

            //Caso queira pesquisar por numero da conta
            if(tipo.equals(TipoMetodologiaPesquisaEnum.NUMERO)){
                int numPesq = JOptionPaneService.paneInt("Qual o número da conta:");
                output = pesquisarNumero(vetOrdenado, numPesq);
            }
            //Caso queira pesquisar por nome do proprietário
            else{
                String pesqNome = JOptionPaneService.paneString("Qual o nome do titular:");
                output = pesquisarNome(vetOrdenado, pesqNome);
            }

            if(output.length == 0)
                throw new PesquisaNaoSucedidaException();
            
            //Retornar contas pesquisadas quando encontradas
            return output;
            
        } catch (PesquisaNaoSucedidaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nPor favor tente novamente");
            
            
            //Perguntar o tipo da metodologia novamente
            String[] opcoesPesq = {"Número da conta", "Nome do destinatário"};

            int escolhaPesq = JOptionPane.showOptionDialog(null, "Como deseja procurar a conta:",
                    "Modo da pesquisa",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesPesq, opcoesPesq[0]);
            
            //Executar a pesquisa novamente
            if(escolhaPesq == 0)
                return pesquisar(vetC, TipoMetodologiaPesquisaEnum.NUMERO);
            else
                return pesquisar(vetC, TipoMetodologiaPesquisaEnum.TITULAR);
        }
    }
    
    
    private static Conta[] pesquisarNumero(Conta[] vet, int pesqNum){
        Conta[] retorno = new Conta[0];
        
        for (int i = 0; i < vet.length; i++) {
            if(pesqNum == vet[i].getNumeroConta()){
                
                Conta[] aux = retorno.clone();
                retorno = new Conta[retorno.length+1];
                System.arraycopy(aux, 0, retorno, 0, aux.length);

                retorno[retorno.length-1] = vet[i];
            }
        }
        return retorno;
    }
    
    private static Conta[] pesquisarNome(Conta[] vet, String pesqNome){
        Conta[] retorno = new Conta[0];
        
        for (int i = 0; i < vet.length; i++) {
            if(pesqNome.toUpperCase().equals(vet[i].getTitular().getNome().toUpperCase())){
                
                Conta[] aux = retorno.clone();
                retorno = new Conta[retorno.length+1];
                System.arraycopy(aux, 0, retorno, 0, aux.length);

                retorno[retorno.length-1] = vet[i];
            }
        }
        return retorno;
    }
}
