package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Endereco;
import br.unipar.SysContasBancarias.utils.ListagemCidadesUtils;
import javax.swing.JOptionPane;

public class EnderecoService {
    
    public void validar(Endereco end) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        CidadeService cidadeServ = new CidadeService();
        
        try {
            cidadeServ.validar(end.getCidade());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Essa cidade não é válida:\n" + ex.getMessage());
        }
        
        if(end == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos do endereço sejam informados!");
        }
        
        
        if(
            end.getLongradouro() == null || 
            end.getLongradouro().isEmpty() || 
            end.getLongradouro().isBlank()
        ){
            throw new CampoNaoInformadoException("Longradouro");
        }
        
        if(end.getNumero() == 0){
            throw new CampoNaoInformadoException("Número");
        }
        
        if(
            end.getBairro() == null || 
            end.getBairro().isEmpty() || 
            end.getBairro().isBlank()
        ){
            throw new CampoNaoInformadoException("Bairro");
        }
        
        if(
            end.getCep() == null || 
            end.getCep().isEmpty() || 
            end.getCep().isBlank()
        ){
            throw new CampoNaoInformadoException("CEP");
        }
        
    }
    
    public Endereco criarEndereco(){
        try{
            Endereco end = new Endereco();

            end.setBairro(JOptionPaneService.paneString("Insira seu bairro:"));
            end.setCep(JOptionPaneService.paneString("Insira seu CEP:"));
            end.setComplemento(JOptionPaneService.paneString("Insira um complemento:"));
            end.setLongradouro(JOptionPaneService.paneString("Insira um longradouro:"));
            end.setNumero(JOptionPaneService.paneInt("Insira o número da casa:"));

            JOptionPane.showMessageDialog(null, "Selecione uma cidade agora");
            end.setCidade(ListagemCidadesUtils.selecionaCidade());

            validar(end);
            return end;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o endereco:\n" + ex.getMessage());
            return criarEndereco();
        }
    }
}
