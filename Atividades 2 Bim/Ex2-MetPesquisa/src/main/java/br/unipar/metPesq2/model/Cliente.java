package br.unipar.metPesq2.model;

public class Cliente {
    private int codigo;
    private String cpf;
    private String nome;
    private String dataNascimento;

    public Cliente() {
    }

    public Cliente(int codigo, String cpf, String nome, String dataNascimento) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
}
