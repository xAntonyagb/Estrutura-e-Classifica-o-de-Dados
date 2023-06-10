package br.unipar.SysContasBancarias.exceptions;

public class SaldoNegativoException extends RuntimeException {
    public SaldoNegativoException(String contas) {
        super("Foi encontrado uma ou mais contas com saldo negativo dentro do banco:\n(Confira o console para vizualizar as contas)");
        System.out.println("Contas com saldo negativo: \n\n" + contas);
    }
}
