package br.unipar.TrabalhoPimeiroBimestre.model;

public class OrdencaoSelecao extends MetodoOrdenacao{

    public OrdencaoSelecao() {
    }

    public OrdencaoSelecao(int[] vetor, int[] vetorOrdenado, long tempoInicio, long tempoFinal, long tempoExecucao) {
        super(vetor, vetorOrdenado, tempoInicio, tempoFinal, tempoExecucao);
    }
    
    
    public void ordenarVetor(int[] vetor){
        long inicio = System.currentTimeMillis();

        for(int i =0; i < vetor.length -1; i++){
            int posMenor = i;
            
            for(int j= i+1; j < vetor.length; j++){
                if(vetor[j] < vetor[posMenor]){
                    posMenor = j;
                }
            }
            if(posMenor != i){
                int aux = vetor [i];
                vetor[i] = vetor[posMenor];
                vetor[posMenor] = aux;
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
        return "OrdencaoSelecao{" + super.toString() +'}';
    }
    
    
}
