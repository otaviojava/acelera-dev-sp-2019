package org.acelera.saopaulo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.acelera.saopaulo.spring")
public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        Carro carro = applicationContext.getBean(Carro.class);
        carro.mover();

    }
}
