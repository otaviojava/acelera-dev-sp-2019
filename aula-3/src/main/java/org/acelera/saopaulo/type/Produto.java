package org.acelera.saopaulo.type;

public class Produto {


    private final Long id;

    private final String nome;

    private final  Dinheiro dinheiro;


    public Produto(Long id, String nome, Dinheiro dinheiro) {
        this.id = id;
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
