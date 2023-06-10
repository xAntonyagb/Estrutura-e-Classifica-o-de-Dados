package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.ContaExistenteException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Banco;
import br.unipar.SysContasBancarias.models.Conta;
import br.unipar.SysContasBancarias.models.Endereco;
import javax.swing.JOptionPane;

public class BancoService {
    
    public void validar(Banco banco) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        ContaService contaServ = new ContaService();
        EnderecoService enderecoServ = new EnderecoService();
        
        try {
            for (Conta conta : banco.getContas()) {
                contaServ.validar(conta);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Uma das contas adicionadas no banco não é válida:\n" + ex.getMessage());
        }
        
        
        try {
            enderecoServ.validar(banco.getEndereco());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Esse endereço não é válido:\n" + ex.getMessage());
        }
        
        
        
        if(banco == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos do banco sejam informados!");
        }
        
        if(
            banco.getCnpj() == null || 
            banco.getCnpj().isEmpty() || 
            banco.getCnpj().isBlank()
        ){
            throw new CampoNaoInformadoException("CNPJ");
        }
        
        if(
            banco.getNome() == null || 
            banco.getNome().isEmpty() || 
            banco.getNome().isBlank()
        ){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(
            banco.getTelefone() == null || 
            banco.getTelefone().isEmpty() || 
            banco.getTelefone().isBlank()
        ){
            throw new CampoNaoInformadoException("Telefone");
        }
    }
    
    public Banco criarBanco(){
        try{
            Banco b = new Banco();

            b.setNome(JOptionPaneService.paneString("Insira o nome do banco:"));
            b.setCnpj(JOptionPaneService.paneString("Insira o CNPJ do banco:"));
            b.setTelefone(JOptionPaneService.paneString("Insira o telefone do banco:"));

            JOptionPane.showMessageDialog(null, "Insira um endereço agora");
            EnderecoService eServ = new EnderecoService();
            Endereco e = eServ.criarEndereco();
            b.setEndereco(e);

            validar(b);
            return b;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o banco:\n" + ex.getMessage());
            return criarBanco();
        }
    }
    
    public static void validaNovaConta(Banco banco, Conta conta) throws ContaExistenteException {
        for(Conta c : banco.getContas()) {
            if(c.getNumeroConta() == conta.getNumeroConta())
                throw new ContaExistenteException();
        }
    }
}
