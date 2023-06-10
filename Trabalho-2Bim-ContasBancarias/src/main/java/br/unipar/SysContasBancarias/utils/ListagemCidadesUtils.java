package br.unipar.SysContasBancarias.utils;

import br.unipar.SysContasBancarias.models.Cidade;
import br.unipar.SysContasBancarias.services.CidadeService;
import javax.swing.JOptionPane;

public class ListagemCidadesUtils {
    public static Cidade[] cidades = new Cidade[0];
    
    public static void addCidade(Cidade c) {
        Cidade[] aux = cidades.clone();
        cidades = new Cidade[cidades.length+1];
        System.arraycopy(aux, 0, cidades, 0, aux.length);

        cidades[cidades.length-1] = c;
    }
    
    public static Cidade selecionaCidade() {
        Cidade c;
        
        String[] opcoes = new String[cidades.length+1];
        
        opcoes[0] = "Adicionar nova";
        
        for(int i = 1; i <= cidades.length; i++) {
            opcoes[i] = cidades[i-1].getNome();
        }
        
        int escolha = JOptionPane.showOptionDialog(null, "Qual é a sua cidade:",
                            "Seleção de cidade",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        
        if(escolha == 0) {
            CidadeService cServ = new CidadeService();
            c = cServ.criarCidade();
            addCidade(c);
        } else {
            c = cidades[escolha-1];
        }
        
        return c;
    }
}
