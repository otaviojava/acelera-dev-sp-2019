package org.acelera.saopaulo.type;

import java.math.BigDecimal;

public class ProdutoUtil {

    public static BigDecimal converter(Produto p) {
        return p.getValor();
    }

    public static BigDecimal converter(Entrega p) {
        return p.getValor();
    }
}
