package br.unipar.SysContasBancarias.enums;

public enum TipoPesquisaEnum {
    LINEAR("Linear"),
    BINARIA("Binária");
    
    String descricao;
    
    private TipoPesquisaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
