package br.unipar.SysContasBancarias.services;

import br.unipar.SysContasBancarias.enums.TipoTransferenciaEnum;
import br.unipar.SysContasBancarias.exceptions.CampoNaoInformadoException;
import br.unipar.SysContasBancarias.exceptions.EntidadeNaoInformadaException;
import br.unipar.SysContasBancarias.exceptions.SaldoZeradoException;
import br.unipar.SysContasBancarias.models.Transferencia;
import javax.swing.JOptionPane;

public class TransferenciaService {
    
    public void validar(Transferencia transf) throws SaldoZeradoException, CampoNaoInformadoException, EntidadeNaoInformadaException {
         if(transf == null){
            throw new EntidadeNaoInformadaException("É obrigatório que os dados da transferencia sejam informados!");
        }
        
        if(transf.getTipo()== null) {
            throw new CampoNaoInformadoException("Tipo de transferencia");
        }
        
        if(transf.getValor() == 0){
            throw new SaldoZeradoException();
        }
    }
    
    public Transferencia criarDeposito() {
        try {
            Transferencia t = new Transferencia();
            t.setTipo(TipoTransferenciaEnum.ENTRADA);
            double valor = JOptionPaneService.paneDouble("Quanto deseja depositar na conta:");
            t.setValor(valor);

            validar(t);
            return t;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer a transferencia:\n" + ex.getMessage());
            return criarDeposito();
        }
    }
    
    public Transferencia criarSaque() {
        try{
            Transferencia t = new Transferencia();
            t.setTipo(TipoTransferenciaEnum.SAIDA);
            double valor = JOptionPaneService.paneDouble("Quanto deseja sacar da conta:");
            t.setValor(valor);

            validar(t);
            return t; 
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer a transferencia:\n" + ex.getMessage());
            return criarSaque();
        }
    }
}
