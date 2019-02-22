package org.acelera.saopaulo;

public class Pessoa {

    //default que visivel
    //private que dentro da classe
    //protected por heranca e pacote
    //
    private String nome;

    private String sobreNome;

    private int idade;

    private String cidade;


    protected Pessoa(String nome, String sobreNome, int idade, String cidade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.cidade = cidade;
    }


    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }


    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }


}
