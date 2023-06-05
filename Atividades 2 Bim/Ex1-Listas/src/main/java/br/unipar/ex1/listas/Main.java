package br.unipar.ex1.listas;

import br.unipar.ex1.listas.model.Fila;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        boolean aberto = true;
        JOptionPane.showMessageDialog(null, "Você abre a clínica para atendimento.");
        
        //Disponibilizando 20 senhas 
        Fila fila = new Fila(20);
        
        do {

            String[] opcoes = {"Adicionar paciente", "Chamar próximo paciente", "Fechar a clínica"};
            int escolha = JOptionPane.showOptionDialog(null, "O que deseja vazer agora?",
                    "Menu de atendimento",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
            
           
            if(escolha == 0) {
                //Cadastrar o paciente
                if(! fila.isFull()){
                    fila.enqueue(
                            JOptionPane.showInputDialog("Insira o nome do paciente:"));
                } 
                //Caso a fila esteja cheia
                else {
                    JOptionPane.showMessageDialog(null, "A fila está lotada.\nPor favor atenda os pacientes presentes primeiro.");
                }
            } 


            else if(escolha ==  1){
                //Atender o paciente
                if(! fila.isEmpty()){
                    String atendido = fila.dequeue();
                    JOptionPane.showMessageDialog(null, "Você atende o paciente:\n" + atendido);
                } 
                //Se nenhum paciente estiver na fila
                else {
                    JOptionPane.showMessageDialog(null, "Ninguem está presente na fila, por favor adicione alguem primeiro.");
                    escolha = 0;
                }
            }
                    
            //Fehcar a loja
            else
                aberto = false;

        } while(aberto);
        
        JOptionPane.showMessageDialog(null, "Você fecha a clínica por hoje.");
    }
}
