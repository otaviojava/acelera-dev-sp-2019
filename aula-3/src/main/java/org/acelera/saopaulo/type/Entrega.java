package org.acelera.saopaulo.type;

import java.math.BigDecimal;
import java.util.Currency;

public class Entrega {

    private Currency currency;

    private BigDecimal valor;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
