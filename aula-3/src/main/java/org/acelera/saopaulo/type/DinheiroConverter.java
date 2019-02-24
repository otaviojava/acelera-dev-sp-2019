package org.acelera.saopaulo.type;

import javax.persistence.AttributeConverter;

public class DinheiroConverter implements AttributeConverter<Dinheiro, String> {

    @Override
    public String convertToDatabaseColumn(Dinheiro attribute) {
        return null;
    }

    @Override
    public Dinheiro convertToEntityAttribute(String dbData) {
        return null;
    }
}
