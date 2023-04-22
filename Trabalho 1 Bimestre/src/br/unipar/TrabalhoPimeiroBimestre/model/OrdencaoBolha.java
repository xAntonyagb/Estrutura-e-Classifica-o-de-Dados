package br.unipar.TrabalhoPimeiroBimestre.model;

public class OrdencaoBolha extends MetodoOrdenacao{
    
    public OrdencaoBolha() {
    }

    public OrdencaoBolha(int[] vetor, int[] vetorOrdenado, long tempoInicio, long tempoFinal, long tempoExecucao) {
        super(vetor, vetorOrdenado, tempoInicio, tempoFinal, tempoExecucao);
    }

    
    public void ordenarVetor(int[] vetor){
        long inicio = System.currentTimeMillis();
        
        boolean troca = true;

        while(troca){
            troca = false;
            
            for(int i = 0; i < vetor.length -1; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }
        long fim = System.currentTimeMillis();
        
        
        super.setTempoInicio(inicio);
        super.setTempoFinal(fim);
        
        super.setVetorOrdenado(vetor);
        super.calularTempoExecucao();
    }

    @Override
    public String toString() {
        return "OrdencaoBolha{" + super.toString() +'}';
    }

}
