package org.acelera.saopaulo.type;

import javax.persistence.AttributeConverter;
import java.util.Currency;

public class CurrencyConverter implements AttributeConverter<Currency, String> {
    @Override
    public String convertToDatabaseColumn(Currency attribute) {
        return attribute.getCurrencyCode();
    }

    @Override
    public Currency convertToEntityAttribute(String dbData) {
        return Currency.getInstance(dbData);
    }
}
