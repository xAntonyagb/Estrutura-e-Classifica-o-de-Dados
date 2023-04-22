package br.unipar.TrabalhoPimeiroBimestre.model;

public class OrdenacaoInsercao extends MetodoOrdenacao{
    
    public OrdenacaoInsercao() {
    }
    
    public OrdenacaoInsercao(int[] vetor, int[] vetorOrdenado, long tempoInicio, long tempoFinal, long tempoExecucao) {
        super(vetor, vetorOrdenado, tempoInicio, tempoFinal, tempoExecucao);
    }


    public void ordenarVetor(int[] vetor){
        long inicio = System.currentTimeMillis();
        
        int chave, j;
        
        for(int i = 1; i < vetor.length; i++){
            chave = vetor[i];
            
            for(j = i-1; (j >= 0) && (vetor[j] > chave); j--){
                vetor[j+1] = vetor[j];
            }
            vetor[j+1] = chave;
        }
        long fim = System.currentTimeMillis();
        
        
        super.setTempoInicio(inicio);
        super.setTempoFinal(fim);
        
        super.setVetorOrdenado(vetor);
        super.calularTempoExecucao();
    }

    @Override
    public String toString() {
        return "OrdenacaoInsercao{" + super.toString() +'}';
    }
    
}
