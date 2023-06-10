package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Cidade;
import br.unipar.SysContasBancarias.utils.ListagemEstadosUtils;
import javax.swing.JOptionPane;

public class CidadeService {
    
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        EstadoService estadoServ = new EstadoService();
        
        try {
            estadoServ.validar(cidade.getEstado());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Esse estado não é válido:\n" + ex.getMessage());
        }
        
        if(cidade == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos da cidade sejam informados!");
        }
        
        if(
            cidade.getNome() == null || 
            cidade.getNome().isEmpty() || 
            cidade.getNome().isBlank()
        ){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(
            cidade.getSigla() == null || 
            cidade.getSigla().isEmpty() || 
            cidade.getSigla().isBlank()
        ){
            throw new CampoNaoInformadoException("Sigla");
        }
    }
    
    public Cidade criarCidade(){
        try{
            Cidade c = new Cidade();

            c.setNome(JOptionPaneService.paneString("Insira o nome da cidade:"));
            c.setSigla(JOptionPaneService.paneString("Insira a sigla da cidade:"));

            JOptionPane.showMessageDialog(null, "Selecione um estado agora");
            c.setEstado(ListagemEstadosUtils.selecionaEstado());

            validar(c);
            return c;
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar a cidade:\n" + ex.getMessage());
            return criarCidade();
        }
    }
    
}
