package br.unipar.TrabalhoPimeiroBimestre.model;

public class MetodoOrdenacao {
    private int[] vetor;
    private int[] vetorOrdenado;
    private long tempoInicio;
    private long tempoFinal;
    private long tempoExecucao;

    public MetodoOrdenacao() {
    }

    public MetodoOrdenacao(int[] vetor, int[] vetorOrdenado, long tempoInicio, long tempoFinal, long tempoExecucao) {
        this.vetor = vetor;
        this.vetorOrdenado = vetorOrdenado;
        this.tempoInicio = tempoInicio;
        this.tempoFinal = tempoFinal;
        this.tempoExecucao = tempoExecucao;
    }
    
    
    public void calularTempoExecucao(){
        this.tempoExecucao = this.tempoFinal - this.tempoInicio;
    }
    
    public String printVetor(int[] vetor){
        String output = "";
        for(int i =0; i < vetor.length; i++){
            output += "vetor[" + i + "] = "+ vetor[i] + "\n";
        }
        return output;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int[] getVetorOrdenado() {
        return vetorOrdenado;
    }

    public void setVetorOrdenado(int[] vetorOrdenado) {
        this.vetorOrdenado = vetorOrdenado;
    }

    public long getTempoInicio() {
        return tempoInicio;
    }

    public void setTempoInicio(long tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public long getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(long tempoFinal) {
        this.tempoFinal = tempoFinal;
    }

    public long getTempoExecucao() {
        calularTempoExecucao();
        return tempoExecucao;
    }

    public void setTempoExecucao(long tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    @Override
    public String toString() {
        return "\n" + printVetor(vetorOrdenado) + "\nTempo Execucao do Metodo: " + tempoExecucao + "\n";
    }
    
    
}
