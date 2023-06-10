package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.models.Pais;
import br.unipar.SysContasBancarias.services.PaisService;
import javax.swing.JOptionPane;

public class ListagemPaisesUtils {
    public static Pais[] paises = new Pais[0];
    
    public static void addPais(Pais p) {
        Pais[] aux = paises.clone();
        paises = new Pais[paises.length+1];
        System.arraycopy(aux, 0, paises, 0, aux.length);

        paises[paises.length-1] = p;
    }
    
    public static Pais selecionaPais() {
        Pais p;
        
        String[] opcoes = new String[paises.length+1];
        
        opcoes[0] = "Adicionar novo";
        
        for(int i = 1; i <= paises.length; i++) {
            opcoes[i] = paises[i-1].getNome();
        }
        
        int escolha = JOptionPane.showOptionDialog(null, "Qual é o seu pais:",
                            "Seleção de pais",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        
        if(escolha == 0) {
            PaisService pServ = new PaisService();
            p = pServ.criarPais();
            addPais(p);
        } else {
            p = paises[escolha-1];
        }
        
        return p;
    }
}
