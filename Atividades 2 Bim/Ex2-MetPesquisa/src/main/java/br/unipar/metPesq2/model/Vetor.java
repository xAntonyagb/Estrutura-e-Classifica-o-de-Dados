package br.unipar.metPesq2.model;

import java.util.Arrays;

public abstract class Vetor {
    private Cliente[] vetor;
    private Cliente[] vetorOrdenado;
    private int tamanho;
    private int codPesq;

    public Vetor(int posPesq) {
        this.codPesq = posPesq;
        vetor = new Cliente[0];
    }

    public Vetor() {
        vetor = new Cliente[0];
    }

    public void setPosPesq(int posPesq) {
        this.codPesq = posPesq;
    }
    
    public void addVet(Cliente c){
       tamanho++;
        
       Cliente[] aux = vetor.clone();
       vetor = new Cliente[vetor.length+1];
       for(int i = 0; i < aux.length; i++){
           vetor[i] = aux[i];
       }
       
       vetor[vetor.length-1] = c;
       System.out.println(Arrays.toString(vetor));
       ordenar();
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public void ordenar() {
        Cliente[] vet = vetor.clone();
        boolean troca = true;
        System.out.println(vet.length);
        if(vet.length > 1) {
            while(troca){
                troca = false;

                for(int i = 0; i < vet.length -1; i++){
                    if(vet[i].getCodigo() > vet[i+1].getCodigo()){
                        Cliente aux = vet[i];
                        vet[i] = vet[i+1];
                        vet[i+1] = aux;
                        troca = true;
                    }

                }
            }
            System.out.println(Arrays.toString(vetor));
            vetorOrdenado = vet;
            System.out.println(Arrays.toString(vetor));
        }
    }

    public Cliente[] getVetor() {
        return vetor;
    }

    public Cliente[] getVetorOrdenado() {
        return vetorOrdenado;
    }

    public int getPosPesq() {
        return codPesq;
    }

    @Override
    public String toString() {
        return "Vetor Ordenado:\n" + Arrays.toString(vetorOrdenado)
                + "\n\nVetor Original:\n" + Arrays.toString(vetor)
                + "\n\nTamanho do Vetor:\n" + tamanho 
                + "\n\nCódigo pesquisado:\n" + codPesq;
    }

}
