package org.acelera.saopaulo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;

@Configuration
public class CounterConfiguration {


    @Bean
    public AtomicLong counter() {
        return new AtomicLong();
    }
}
