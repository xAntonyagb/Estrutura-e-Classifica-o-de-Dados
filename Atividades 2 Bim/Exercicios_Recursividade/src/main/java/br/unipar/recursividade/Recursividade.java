package br.unipar.recursividade;

import javax.swing.JOptionPane;

public class Recursividade {

    public static void main(String[] args) {
        
        String[] escolha = {"Exercício 1", "Exercício 2", "Exercício 3"};
        int ex = JOptionPane.showOptionDialog(null, "Escolha qual exercício deseja rodar:",
        "Escolha de exercício",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[0]);
        
        
        if(ex == 0)
            System.out.println(soma(0));
        
        else if(ex == 1)
            System.out.println(
                    fatorial(
                        Integer.parseInt(
                                JOptionPane.showInputDialog("Que número deseja fazer o fatorial?")
                        )
                    )
            );
        
        else{
            int numComeco =  Integer.parseInt(
                    JOptionPane.showInputDialog("De que posição da sequencia você deseja que comece a ser impreço?\n\nPS: Não exagere, posições altas podem demorar."));
            for(int i = numComeco; i < numComeco+20; i++) {
                System.out.println(fibonacci(i));
            }
        }
            
        
    }

    private static int soma(int num){
       if(num < 50){
           return num + soma(num + 1);
       }else{
           return num;
       }
    }
    
    private static int fatorial(int num){
        
        if(num <= 1){
            return num;
        }
        else{
            return (num * fatorial(num-1));
        }
    }
    
    private static long fibonacci(long num){
            if(num > 1)
                return fibonacci(num-2) + fibonacci(num-1);
            else
                return num;
    }
            
        
}

