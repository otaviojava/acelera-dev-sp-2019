package org.acelera.saopaulo.type;

import java.math.BigDecimal;
import java.util.Currency;

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

    public BigDecimal getValor() {
        return valor;
    }

    public Currency getCurrency() {
        return currency;
    }
}
