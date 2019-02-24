package org.acelera.saopaulo.type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    public BigDecimal getTotal() {
        return produtos.stream()
                .map(ProdutoUtil::converter)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
