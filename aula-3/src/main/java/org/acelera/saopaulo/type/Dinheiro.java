package org.acelera.saopaulo.type;

import java.math.BigDecimal;
import java.util.Currency;

public class Dinheiro {

    private final Currency currency;

    private final BigDecimal valor;

    public Dinheiro(Currency currency, BigDecimal valor) {
        this.currency = currency;
        this.valor = valor;
    }


    public Dinheiro somar(Dinheiro dinheiro) {
        if (dinheiro.currency.equals(currency)) {
            return new Dinheiro(currency, valor.add(dinheiro.valor));
        }
        throw new DinheiroException("Vc nao pode converter");
    }


}
