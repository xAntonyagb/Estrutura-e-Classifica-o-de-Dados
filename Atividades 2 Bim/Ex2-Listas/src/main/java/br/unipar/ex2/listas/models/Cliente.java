package br.unipar.ex2.listas.models;

public class Cliente {
    private String senha;
    private String nome;
    private int anoNascimento;

    public Cliente() {
    }

    public Cliente(String senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "senha=" + senha + ", nome=" + nome + ", anoNascimento=" + anoNascimento + '}';
    }
    
    
}
