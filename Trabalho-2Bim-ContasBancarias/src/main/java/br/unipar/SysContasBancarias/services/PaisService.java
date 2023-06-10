package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Pais;
import javax.swing.JOptionPane;


public class PaisService {
    
    public void validar(Pais pais) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        if(pais == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos do pais sejam informados!");
        }
            
        if(
            pais.getNome() == null || 
            pais.getNome().isEmpty() || 
            pais.getNome().isBlank()
        ){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(
            pais.getSigla() == null || 
            pais.getSigla().isEmpty() || 
            pais.getSigla().isBlank()
        ){
            throw new CampoNaoInformadoException("Sigla");
        }
    }
    
    public Pais criarPais(){
        try{
            Pais p = new Pais();

            p.setNome(JOptionPaneService.paneString("Insira o nome do Pais:"));
            p.setSigla(JOptionPaneService.paneString("Insira a sigla do Pais:"));

            validar(p);
            return p;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o pais:\n" + ex.getMessage());
            return criarPais();
        }
    }
}
