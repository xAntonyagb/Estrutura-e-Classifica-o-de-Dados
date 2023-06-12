package br.unipar.ex2.listas.models;

import java.util.Arrays;

public class Fila {
    private Cliente[] filaPessoas;
    private int frente;
    private int fim;
    private int qtdItens;
    
    public Fila(int tamanho){
        filaPessoas = new Cliente[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    //Adiciona
    public void enqueue(Cliente cliente){
        if(fim == filaPessoas.length -1)
            fim = -1;
        
        filaPessoas[++fim] = cliente;
        qtdItens++;
        
    }
    
    //Diminui
    public Cliente dequeue(){
        Cliente aux = filaPessoas[frente++];
        
        if(frente == filaPessoas.length) 
            frente = 0;
        
        qtdItens--;
        return aux;
    }
    
    //Se ta vazio
    public boolean isEmpty() {
        return qtdItens == 0;
    }
    
    //Se ta cheio
    public boolean isFull() {
        return qtdItens == filaPessoas.length;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    @Override
    public String toString() {
        return "Fila{ Frente = " + frente + ", Fim = " + fim + ", Quantidade de pessoas = " + qtdItens + "\nFila total = " + Arrays.toString(filaPessoas) + "\n}";
    }
    
    
    
}
