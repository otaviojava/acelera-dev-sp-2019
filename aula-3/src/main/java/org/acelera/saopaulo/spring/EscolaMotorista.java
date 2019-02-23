package org.acelera.saopaulo.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class EscolaMotorista {

    @Bean
    @Qualifier("bom")
    @Primary
    public Motorista criar() {
        return new Motorista("Rubens");
    }

    @Bean
    @Qualifier("bom")
    public Motorista cuim() {
        return new Motorista("Otavio");
    }
}
