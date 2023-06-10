package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Estado;
import br.unipar.SysContasBancarias.utils.ListagemPaisesUtils;
import javax.swing.JOptionPane;


public class EstadoService {
    
    public void validar(Estado estado) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        PaisService paisServ = new PaisService();
        
        try{
            paisServ.validar(estado.getPais());
        } catch (Exception ex){
            System.out.println("Esse pais não é válido:\n" + ex.getMessage());
        }
                
        if(estado == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos do estado sejam informados!");
        }
            
        if(
            estado.getNome() == null || 
            estado.getNome().isEmpty() || 
            estado.getNome().isBlank()
        ){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(
            estado.getSigla() == null || 
            estado.getSigla().isEmpty() || 
            estado.getSigla().isBlank()
        ){
            throw new CampoNaoInformadoException("Sigla");
        }
    }
    
    public Estado criarEstado(){
        try{
            Estado e = new Estado();

            e.setNome(JOptionPaneService.paneString("Insira o nome do estado:"));
            e.setSigla(JOptionPaneService.paneString("Insira a sigla do estado:"));

            JOptionPane.showMessageDialog(null, "Selecione um pais agora");
            e.setPais(ListagemPaisesUtils.selecionaPais());

            validar(e);
            return e;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o estado:\n" + ex.getMessage());
            return criarEstado();
        }
    }
}
