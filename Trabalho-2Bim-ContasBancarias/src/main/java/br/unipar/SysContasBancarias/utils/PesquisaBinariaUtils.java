package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.exceptions.PesquisaNaoSucedidaException;
import br.unipar.SysContasBancarias.models.Conta;
import br.unipar.SysContasBancarias.services.JOptionPaneService;
import javax.swing.JOptionPane;

public class PesquisaBinariaUtils {
    
    
    public static Conta pesquisarConta(Conta[] vetC){
        //Tratamento caso não ache na pesquisa
        try{
            
            //Ordenando o vetor
            Conta[] vetOrdenado = OrdenacaoLinearUtils.ordenarContasNum(vetC);
            
            //Perguntando o numero da conta e pesquisando
            int numPesq = JOptionPaneService.paneInt("Qual o número da conta:");
            int pos = pesquisaBinaria(vetOrdenado, numPesq);

            //Caso não encontre, lança exceção de falha
            if(pos == -1)
                throw new PesquisaNaoSucedidaException();
            
            //Retornar conta pesquisada quando encontrada
            return vetOrdenado[pos];
            
        } catch (PesquisaNaoSucedidaException ex) {
            //Loopa até achar
            JOptionPane.showMessageDialog(null, ex.getMessage() + " (Resultado -1)\nPor favor tente novamente");
            return pesquisarConta(vetC);
        }
    }
    
    //Metodo de pesquisa binaria
    private static int pesquisaBinaria(Conta[] vet, int pesqNum) {
        
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/2;
            if(pesqNum == vet[meio].getNumeroConta()){
                return meio;
            }
            if(pesqNum > vet[meio].getNumeroConta()){
                esquerda = meio +1;
            }else{
                direita = meio -1;
            }
        }
        
        return -1;
    }  
}
