package org.acelera.saopaulo;

public class PessoaBuilder {

    @SuppressWarnings("unused")
	private String nome;

    @SuppressWarnings("unused")
	private String sobreNome;

    @SuppressWarnings("unused")
	private int idade;

    @SuppressWarnings("unused")
	private String cidade;

    PessoaBuilder() {
    }

    public PessoaBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
        return this;
    }

    public PessoaBuilder setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public PessoaBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }
}
