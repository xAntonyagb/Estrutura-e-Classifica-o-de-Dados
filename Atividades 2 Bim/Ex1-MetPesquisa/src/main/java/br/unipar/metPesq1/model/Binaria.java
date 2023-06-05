package br.unipar.metPesq1.model;

import br.unipar.metPesq1.model.abstracts.MetodoPesquisa;
import java.util.Arrays;

public class Binaria extends MetodoPesquisa {
    
    @Override
    public void pesquisar(){
        int[] vet = super.getVetorOrdenado();
        int numPesq = super.getNumPesquisa();
        
        int esquerda, meio, direita;
        
        esquerda = 0;
        direita = vet.length - 1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/2;
            if(numPesq == vet[meio]){
                super.setPosicoesPesquisa(""+meio);
            }
            if(numPesq > vet[meio]){
                esquerda = meio +1;
            }else{
                direita = meio -1;
            }
        }
        
        if((esquerda <= direita))
            super.setPosicoesPesquisa("-1");
    }
    
    @Override
    public String toString() {
        return "Posição de '"+ super.getNumPesquisa() + "': \n" + super.getPosicoesEncontradas() + "\nVetor: \n" + Arrays.toString(super.getVetor()) + "\nVetor não ordenado: \n" + Arrays.toString(super.getVetor());
    }
}
