package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App5 {

    public static void main(String[] args) {
        Pessoa mario =
                new Pessoa("Mario", "JoinVille", 40);

        Pessoa otavio =
                new Pessoa("Otavio", "Salvador", 20);


        List<Pessoa> bancada = new ArrayList<>();
        bancada.add(mario);
        bancada.add(otavio);
        Predicate<Pessoa> maiorFiltro = p -> p.getIdade() > 18;
        Predicate<Pessoa> ehSalvador = p -> "Salvador".equals(p.getCidade());

        List<Pessoa> maior = bancada.stream()
                .filter(maiorFiltro.or(ehSalvador))
                .collect(Collectors.toList());

        List<String> nomes = bancada.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());

        String nomesVirgula = bancada.stream()
                .map(p -> p.getNome())
                .collect(Collectors.joining(","));


        int sum = bancada.stream()
                .mapToInt(p -> p.getIdade()).sum();

        Optional<Integer> reduce = bancada.stream()
                .map(p -> p.getIdade())
                .reduce((a, b) -> Integer.sum(a, b));

        if(reduce.isPresent()) {
            Integer somatorio = reduce.get();
        }

        reduce.orElseGet(() -> 23);


    }

}
