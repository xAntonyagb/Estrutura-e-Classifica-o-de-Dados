package br.unipar.SysContasBancarias.models;

public class Endereco {
    private String longradouro;
    private int numero;
    private String bairro;
    private String cep;
    private String complemento;
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String longradouro, int numero, String bairro, String cep, String complemento, Cidade cidade) {
        this.longradouro = longradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
    }


    public String getLongradouro() {
        return longradouro;
    }

    public void setLongradouro(String longradouro) {
        this.longradouro = longradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "Longradouro = " + longradouro + ", Numero = " + numero + ", bairro = " + bairro + ", CEP = " + cep + ", Complemento = " + complemento + ", Cidade = " + cidade + '}';
    }
    
    
}
