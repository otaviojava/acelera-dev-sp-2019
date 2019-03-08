package org.acelera.saopaulo.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ComponentScan(basePackages = "org.acelera.saopaulo.spring")
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        AnimalRepository repository = applicationContext.getBean(AnimalRepository.class);
        repository.save(Animal.of("Leao"));
        repository.save(Animal.of("Foca"));
        repository.save(Animal.of("Gato"));
        repository.save(Animal.of("Cachorro"));
        repository.save(Animal.of("baleia"));

        Pageable page = PageRequest.of(1, 2);

        Page<Animal> all = repository.findAll(page);

        for (Animal animal : all) {
            System.out.println(animal);
        }


    }
}
