package br.unipar.SysContasBancarias.exceptions;

public class SaldoZeradoException extends RuntimeException {
    public SaldoZeradoException() {
        super("Dado saldo não é de valor válido para uma transferencia");
    }
}
