package br.unipar.SysContasBancarias.models;

import br.unipar.SysContasBancarias.enums.TipoTransferenciaEnum;

public class Conta {
    private int numeroConta;
    private Pessoa titular;
    private double saldoTransferencias;
    private double saldoInicial;
    private Transferencia[] transferencias = new Transferencia[0];

    public Conta() {
        this.saldoTransferencias = this.saldoInicial;
    }

    public Conta(int numeroConta, Pessoa titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldoInicial = saldoInicial; 
        this.saldoTransferencias = this.saldoInicial;
    }
    
    public void addTransferencia(Transferencia transf) {
        Transferencia[] aux = transferencias.clone();
        transferencias = new Transferencia[transferencias.length+1];
        System.arraycopy(aux, 0, transferencias, 0, aux.length);

        transferencias[transferencias.length-1] = transf;
        calcularSaldoTransferencias();
    }
    
    public void calcularSaldoTransferencias() {
        double total = saldoInicial;
        
        for(Transferencia transf : transferencias){
            
            if(transf.getTipo() == TipoTransferenciaEnum.ENTRADA)
                total += transf.getValor();
            else
                total -= transf.getValor();
        }
        
        this.saldoTransferencias = total; 
    }

    public double getSaldoTransferencias() {
        calcularSaldoTransferencias();
        return saldoTransferencias;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Transferencia[] getTransferencias() {
        return transferencias;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @Override
    public String toString() {
        return "Conta{ \nNumero da conta = " + numeroConta + "\nSaldo (inicial): " + saldoInicial + ",\nSaldo com as transferencias = " + getSaldoTransferencias() + ",\nTitular = " + titular + "\n}";
    }
    
    
}
