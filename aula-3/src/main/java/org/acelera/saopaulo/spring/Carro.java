package org.acelera.saopaulo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Carro {

    @Autowired
    @Qualifier("bom")
    private Motorista motorista;

    public Motorista getMotorista() {
        return motorista;
    }

    public void mover() {
        System.out.println("movendo com o motorista " + motorista);
    }
}
