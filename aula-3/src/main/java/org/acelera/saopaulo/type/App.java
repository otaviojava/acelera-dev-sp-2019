package org.acelera.saopaulo.type;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class App {

    public static void main(String[] args) {

        Currency real = Currency.getInstance("BRL");
        Currency dolar = Currency.getInstance("USD");
        Produto banana = new Produto(1L, "Banana", BigDecimal.TEN, real);
        Produto caneta = new Produto(1L, "Caneta", BigDecimal.TEN, real);
        Produto mac = new Produto(1L, "Caneta", BigDecimal.valueOf(1_000), dolar);
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(caneta);
        carrinho.adicionar(banana);
        carrinho.adicionar(mac);
        System.out.println(carrinho.getTotal());


    }
}
