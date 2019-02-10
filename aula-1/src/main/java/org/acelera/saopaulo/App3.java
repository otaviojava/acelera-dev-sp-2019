package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.List;

public class App3 {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        for (int index = 1; index <= 1_000; index++) {
            numeros.add(index);
        }
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int index = 1; index <= 1_000; index++) {
            if(index % 2 == 0) {
                pares.add(index);
            } else {
                impares.add(index);
            }
        }

        System.out.println("pares ");
        for (Integer pare : pares) {
            System.out.println(pare);
        }

        impares.forEach(i -> System.out.println(i));
        impares.forEach(System.out::println);
        for (Integer impar : impares) {
            System.out.println(impar);
        }
    }
}
