package br.unipar.metPesq1.model;

import javax.swing.JOptionPane;
public class Vetor {
    
    private int[] vetor;
    private int[] vetorOrdenado;

    public Vetor() {
    }

    public Vetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void populaVetor(){
        int[] vet = this.vetor;
        
        for(int i=0; i < vet.length; i++){
            vet[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Insira o número da "+ i +" posição:")
            );
        }
        
        this.vetor = vet;
        ordenarVetor();
    }
    
    public void criarVetor(int tamanho){
        this.vetor = new int[tamanho];
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
    
    public void ordenarVetor(){
        boolean troca = true;
        

        while(troca){
            troca = false;
            vetorOrdenado = vetor;
            
            for(int i = 0; i < vetorOrdenado.length -1; i++){
                if(vetorOrdenado[i] > vetorOrdenado[i+1]){
                    int aux = vetorOrdenado[i];
                    vetorOrdenado[i] = vetorOrdenado[i+1];
                    vetorOrdenado[i+1] = aux;
                    troca = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Vetor{" + "vetor=" + vetor + ", vetorOrdenado=" + vetorOrdenado + '}';
    }

}
