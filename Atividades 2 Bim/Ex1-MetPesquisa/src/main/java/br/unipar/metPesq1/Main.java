package br.unipar.metPesq1;

import br.unipar.metPesq1.model.Binaria;
import br.unipar.metPesq1.model.Linear;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
         
        
        String[] escolha = {"Binária", "Linear"};
        int tipo = JOptionPane.showOptionDialog(null, "Escolha qual tipo de pesquisa deseja fazer:",
                "Tipo de pesquisa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[0]);
        
        //Escolher quantidade de posições
        int qtdPos = Integer.parseInt(
                JOptionPane.showInputDialog("Quantas posições deve ter o vetor:")
        );
        
        //Se for binária
        if(tipo == 0){
            Binaria binaria = new Binaria();
            binaria.criarVetor(qtdPos);
            binaria.populaVetor();
            
            int numPesquisa = Integer.parseInt(
                    JOptionPane.showInputDialog("Que número deseja pesquisar?")
            );

            binaria.setNumPesquisa(numPesquisa);
            binaria.pesquisar();

            JOptionPane.showMessageDialog(null, binaria.toString());
        }
        
        //Se for Linear
        else{
            
            Linear linear = new Linear();
            linear.criarVetor(qtdPos);
            linear.populaVetor();
            
            int numPesquisa = Integer.parseInt(
                    JOptionPane.showInputDialog("Que número deseja pesquisar?")
            );

            linear.setNumPesquisa(numPesquisa);
            linear.pesquisar();

            JOptionPane.showMessageDialog(null, linear.toString());
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
            
            
    }
}
