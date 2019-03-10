package org.acelera.saopaulo.revisao;

public abstract class BaseTrabalhador implements Trabalhador {

    private final String nome;

    private final String cidade;


    protected BaseTrabalhador(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public void trabalhar() {
        System.out.println("estou trabalhando, e recebi: " + getSalario());
    }

}
