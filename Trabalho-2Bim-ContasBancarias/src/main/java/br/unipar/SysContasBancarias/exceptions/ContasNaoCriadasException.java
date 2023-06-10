package br.unipar.SysContasBancarias.exceptions;

public class ContasNaoCriadasException extends RuntimeException {
    public ContasNaoCriadasException() {
        super("Nenhuma conta foi criada ainda.\nPor favor crie uma conta primeiramente:");
    }
}
