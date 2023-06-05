package br.unipar.metPesq2;

import br.unipar.metPesq2.model.Cliente;
import br.unipar.metPesq2.model.PesqBinaria;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantas pessoa deseja adicionar?"));
        PesqBinaria pesquisa = new PesqBinaria(qtd);
        
        for(int i = 0; i < qtd; i++){
            int cod = Integer.parseInt(JOptionPane.showInputDialog("Pessoa "+ i +":\nQual será o codigo dessa pessoa"));
            String nome = JOptionPane.showInputDialog("Pessoa "+ i +":\nQual o nome dessa pessoa");
            String cpf = JOptionPane.showInputDialog("Pessoa "+ i +":\nQual o cpf dessa pessoa");
            String dataNascimento = JOptionPane.showInputDialog("Pessoa "+ i +":\nQual a data de nascimento dessa pessoa");
            
            pesquisa.addVet(new Cliente(cod, cpf, nome, dataNascimento));
        }
        
        int codPesq = Integer.parseInt(JOptionPane.showInputDialog("Por qual código deseja buscar?"));
        pesquisa.setPosPesq(codPesq);
        int retorno = pesquisa.pesquisar();
        
        if(retorno == -1)
            JOptionPane.showMessageDialog(null, "Cliente escontrado!\nPosição do cliente:\n"+ retorno + "\n\n" + pesquisa.toString());
        
        else
            JOptionPane.showMessageDialog(null, "Cliente não escontrado!\nPosição:\n"+ retorno + "\n\n" + pesquisa.toString());
        
    }
}
