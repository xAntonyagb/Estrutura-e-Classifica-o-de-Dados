package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.models.Conta;

public class OrdenacaoLinearUtils {
    
    public static Conta[] ordenarContasNum(Conta[] vetC){
        Conta[] vetor = vetC.clone();
        boolean troca = true;
        
        while(troca){
            troca = false;
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i].getNumeroConta() > vetor[i+1].getNumeroConta()){
                    Conta aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
            
        }
        return vetor;
    }
    
    public static Conta[] ordenarContasSaldo(Conta[] vetC){
        Conta[] vetor = vetC.clone();
        boolean troca = true;
        
        while(troca){
            troca = false;
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i].getSaldoInicial()> vetor[i+1].getSaldoInicial()){
                    Conta aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
            
        }
        return vetor;
    }
    
}
