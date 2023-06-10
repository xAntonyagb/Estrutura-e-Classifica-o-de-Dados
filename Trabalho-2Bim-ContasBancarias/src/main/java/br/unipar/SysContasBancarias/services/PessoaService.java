package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Endereco;
import br.unipar.SysContasBancarias.models.Pessoa;
import javax.swing.JOptionPane;

public class PessoaService {
    
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        EnderecoService enderecoServ = new EnderecoService();
        
        try {
            enderecoServ.validar(pessoa.getEndereco());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Esse endereço não é válido:\n" + ex.getMessage());
        }
        
        
        if(pessoa == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos da cidade sejam informados!");
        }
        
        if(
            pessoa.getNome() == null || 
            pessoa.getNome().isEmpty() || 
            pessoa.getNome().isBlank()
        ){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(
            pessoa.getDataNascimento() == null || 
            pessoa.getDataNascimento().isEmpty() || 
            pessoa.getDataNascimento().isBlank()
        ){
            throw new CampoNaoInformadoException("Data de Nascimento");
        }
        
        if(
            pessoa.getCpf() == null || 
            pessoa.getCpf().isEmpty() || 
            pessoa.getCpf().isBlank()
        ){
            throw new CampoNaoInformadoException("CPF");
        }
        
        if(
            pessoa.getRg() == null || 
            pessoa.getRg().isEmpty() || 
            pessoa.getRg().isBlank()
        ){
            throw new CampoNaoInformadoException("RG");
        }
        
        if(
            pessoa.getTelefone() == null || 
            pessoa.getTelefone().isEmpty() || 
            pessoa.getTelefone().isBlank()
        ){
            throw new CampoNaoInformadoException("Telefone");
        }
    }
    
    public Pessoa criarPessoa(){
        try{
            Pessoa p = new Pessoa();

            p.setCpf(JOptionPaneService.paneString("Insira um CPF:"));
            p.setDataNascimento(JOptionPaneService.paneString("Insira sua data de nascimento:"));
            p.setNome(JOptionPaneService.paneString("Insira seu nome:"));
            p.setRg(JOptionPaneService.paneString("Insira seu Rg:"));
            p.setTelefone(JOptionPaneService.paneString("Insira seu telefone:"));

            JOptionPane.showMessageDialog(null, "Insira os dados do endereço agora");
            EnderecoService endServ = new EnderecoService();
            Endereco end = endServ.criarEndereco();
            p.setEndereco(end);

            validar(p);
            return p;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel registrar a pessoa:\n" + ex.getMessage());
            return criarPessoa();
        }
    }
}
