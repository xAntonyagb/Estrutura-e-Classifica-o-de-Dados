package br.unipar.metPesq2.model;

public class PesqBinaria extends Vetor {

    public PesqBinaria() {
    }

    public PesqBinaria(int codPesq) {
        super(codPesq);
    }

    public int pesquisar(){
        Cliente[] vet = super.getVetorOrdenado();
        int pesq = super.getPosPesq();
        
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/2;
            if(pesq == vet[meio].getCodigo()){
                return meio;
            }
            if(pesq > vet[meio].getCodigo()){
                esquerda = meio +1;
            }else{
                direita = meio -1;
            }
        }
        
        return -1;
    }
    
    public int pesquisar(int posPesq){
        Cliente[] vet = super.getVetorOrdenado();
        
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/2;
            if(posPesq == vet[meio].getCodigo()){
                return meio;
            }
            if(posPesq > vet[meio].getCodigo()){
                esquerda = meio +1;
            }else{
                direita = meio -1;
            }
        }
        
        return -1;
    }
    
    
}
