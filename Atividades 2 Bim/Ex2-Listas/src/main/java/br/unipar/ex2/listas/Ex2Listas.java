package br.unipar.ex2.listas;

import br.unipar.ex2.listas.models.Banco;
import br.unipar.ex2.listas.models.Cliente;
import javax.swing.JOptionPane;

public class Ex2Listas {

    public static void main(String[] args) {
        
        boolean aberto = true;
        JOptionPane.showMessageDialog(null, "Você abre o banco para atendimento.");
        
        int qtdNormal = Integer.parseInt(
                JOptionPane.showInputDialog("Quantas senhas deseja desponibilizar para a fila comum:"));
        
        int qtdPioritaria = Integer.parseInt(
                JOptionPane.showInputDialog("Quantas senhas deseja desponibilizar para a fila prioritária:"));
        
        
        Banco banco = new Banco(qtdNormal, qtdPioritaria);
        
        do {

            String[] opcoes = {"Adicionar cliente", "Chamar próximo cliente", "Fechar o banco"};
            int escolha = JOptionPane.showOptionDialog(null, "O que deseja vazer agora?",
                    "Menu de atendimento",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
            
           
            if(escolha == 0) {
                Cliente cliente = new Cliente();
                
                String nome = JOptionPane.showInputDialog("Qual o nome do paciente:");
                
                int anoNascimentoPaciente = Integer.parseInt(
                JOptionPane.showInputDialog("Qual o ano de nasciemento do paciente:"));
                
                cliente.setAnoNascimento(anoNascimentoPaciente);
                cliente.setNome(nome);
                
                banco.adicionar(cliente);
            } 


            else if(escolha ==  1){
                //Atender o paciente
                if( (! banco.getFilaNormal().isEmpty()) || (! banco.getFilaPrioritaria().isEmpty()) ){
                    banco.atender();
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
        
        JOptionPane.showMessageDialog(null, "Você fecha o banco por hoje.");
    }
}
