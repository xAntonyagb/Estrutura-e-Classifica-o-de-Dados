package br.unipar.SysContasBancarias.exceptions;

public class PesquisaNaoSucedidaException extends RuntimeException {
    public PesquisaNaoSucedidaException(){
        super("Não foi possivel encontrar a conta pela pesquisa.");
    }
}
