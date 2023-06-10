package br.unipar.SysContasBancarias.exceptions;

public class ContaExistenteException extends RuntimeException {
    public ContaExistenteException(){
        super("Esse número de conta já existe no banco!");
    }
}
