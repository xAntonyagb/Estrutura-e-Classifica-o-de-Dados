package br.unipar.ex1.listas.model;

public class Fila {
    private String[] filaPessoas;
    private int frente;
    private int fim;
    private int qtdItens;
    
    public Fila(int tamanho){
        filaPessoas = new String[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    //Adiciona
    public void enqueue(String nome){
        if(fim == filaPessoas.length -1)
            fim = -1;
        
        filaPessoas[++fim] = nome;
        qtdItens++;
        
    }
    
    //Diminui
    public String dequeue(){
        String aux = filaPessoas[frente++];
        
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
    
}
