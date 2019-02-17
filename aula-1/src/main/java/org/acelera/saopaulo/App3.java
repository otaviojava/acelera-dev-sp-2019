package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.List;

public class App3 {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        for (int index = 1; index <= 1_000; index++) {
            numeros.add(index);
        }
        
        numeros.forEach(System.out::println);

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        
        numeros.forEach(x -> {
        	if(x % 2 == 0) {
        		pares.add(x);
        	}else {
        		impares.add(x);
        	}
        });


        System.out.println("pares ");
        pares.forEach(System.out::println);
        
        System.out.println("impares ");
        impares.forEach(System.out::println);        
    }
}
