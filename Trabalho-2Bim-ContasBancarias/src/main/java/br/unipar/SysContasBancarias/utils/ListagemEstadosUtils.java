package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.models.Estado;
import br.unipar.SysContasBancarias.services.EstadoService;
import javax.swing.JOptionPane;

public class ListagemEstadosUtils {
    public static Estado[] estados = new Estado[0];
    
    public static void addEstado(Estado e) {
        Estado[] aux = estados.clone();
        estados = new Estado[estados.length+1];
        System.arraycopy(aux, 0, estados, 0, aux.length);

        estados[estados.length-1] = e;
    }
    
    public static Estado selecionaEstado() {
        Estado e;
        
        String[] opcoes = new String[estados.length+1];
        
        opcoes[0] = "Adicionar novo";
        
        for(int i = 1; i <= estados.length; i++) {
            opcoes[i] = estados[i-1].getNome();
        }
        
        int escolha = JOptionPane.showOptionDialog(null, "Qual é o seu estado:",
                            "Seleção de estado",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        
        if(escolha == 0) {
            EstadoService pServ = new EstadoService();
            e = pServ.criarEstado();
            addEstado(e);
        } else {
            e = estados[escolha-1];
        }
        
        return e;
    }
}
