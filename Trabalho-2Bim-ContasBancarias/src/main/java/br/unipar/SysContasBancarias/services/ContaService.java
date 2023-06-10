
package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.models.Conta;
import br.unipar.SysContasBancarias.models.Pessoa;
import javax.swing.JOptionPane;

public class ContaService {
    
    public void validar(Conta conta) throws EntidadeNaoInformadaException, CampoNaoInformadoException  {
        
        PessoaService pessoaServ = new PessoaService();
        
        try {
            pessoaServ.validar(conta.getTitular());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Essa pessoa não é válida:\n" + ex.getMessage());
        }
        
        if(conta == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os campos da conta sejam informados!");
        }
            
        if(conta.getNumeroConta() == 0){
            throw new CampoNaoInformadoException("Nome");
        }  
    }
    
    public Conta criarConta(){
        try{
            Conta c = new Conta();
            c.setNumeroConta(JOptionPaneService.paneInt("Insira um número de conta:"));
            c.setSaldoInicial(JOptionPaneService.paneDouble("Insira um saldo inicial para a conta:"));

            JOptionPane.showMessageDialog(null, "Insira os dados do titular agora");
            PessoaService pServ = new PessoaService();
            Pessoa p = pServ.criarPessoa(); 
            c.setTitular(p);

            validar(c);
            return c;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar a conta:\n" + ex.getMessage());
            return criarConta();
        }
    }
}
