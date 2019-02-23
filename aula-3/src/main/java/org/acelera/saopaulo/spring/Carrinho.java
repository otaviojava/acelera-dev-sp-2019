package org.acelera.saopaulo.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    @Autowired
    private Compra compra;

    public void comprar() {
        compra.finalizo(produtos);
    }
}
