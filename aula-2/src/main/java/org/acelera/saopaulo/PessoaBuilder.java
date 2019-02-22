package org.acelera.saopaulo;

public class PessoaBuilder {

	private String nome;

	private String sobreNome;

	private int idade;

	private String cidade;

    protected PessoaBuilder() {}

    public PessoaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder withSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
        return this;
    }

    public PessoaBuilder withIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public PessoaBuilder withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }
    
    public Pessoa build() {
    	return new Pessoa(nome, sobreNome, idade, cidade);
    }
}
