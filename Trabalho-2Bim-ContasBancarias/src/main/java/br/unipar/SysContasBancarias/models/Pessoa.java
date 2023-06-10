package br.unipar.SysContasBancarias.models;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    private Endereco endereco;
    private String cpf;
    private String rg;
    private String telefone;

    public Pessoa(String nome, String dataNascimento, Endereco endereco, String cpf, String rg, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
    }

    public Pessoa() {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Nome = " + nome + ", Data de nascimento = " + dataNascimento + ", CPF = " + cpf + ", RG = " + rg + ", Telefone = " + telefone + ", Endereco = " + endereco + '}';
    }
}
