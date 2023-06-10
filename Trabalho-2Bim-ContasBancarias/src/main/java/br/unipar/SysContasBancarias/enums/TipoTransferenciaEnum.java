package br.unipar.SysContasBancarias.enums;

public enum TipoTransferenciaEnum {
    SAIDA("Saída"),
    ENTRADA("Entrada");
    
    String descricao;
    
    private TipoTransferenciaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
