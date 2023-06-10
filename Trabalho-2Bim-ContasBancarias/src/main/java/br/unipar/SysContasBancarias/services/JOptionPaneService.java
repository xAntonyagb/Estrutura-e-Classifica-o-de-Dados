package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import javax.swing.JOptionPane;

public class JOptionPaneService {
    
    public static int paneInt(String msg){
        int outputI;
        
        try{
            outputI = Integer.parseInt(JOptionPane.showInputDialog(msg));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Input inválido, tente inserir outro número.");
            outputI = paneInt(msg);
        }
        
        return outputI;
    }
    
    public static String paneString(String msg) {
        String output;
        
        try{
            output = JOptionPane.showInputDialog(msg);
            
            if(
                output == null || 
                output.isEmpty() || 
                output.isBlank()
            ){
                throw new CampoNaoInformadoException("JOptionPane");
            }
            
            
        } catch (CampoNaoInformadoException ex) {
            JOptionPane.showMessageDialog(null, "Input inválido, insira novamente.");
            output = paneString(msg);
        }
        
        return output;
    }
    
    public static double paneDouble(String msg) {
        double output;
        
        try{
            output = Double.parseDouble(JOptionPane.showInputDialog(msg));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Input inválido, tente inserir outro número.");
            output = paneDouble(msg);
        }
        
        return output;
    }
}
