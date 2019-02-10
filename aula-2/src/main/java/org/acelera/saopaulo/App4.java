package org.acelera.saopaulo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App4 {

    public static void main(String[] args) {

        Map<String, Integer> estoque = new HashMap<>();

        estoque.put("Banana", 3);
        estoque.put("Melao", 5);
        estoque.put("Coca cola", 10);
        estoque.put("Cerveja", 20);
        estoque.put("Vinho Seco vermelho", 1);

        //consumir duas bananas
        //consumir 3 meloes
        //consumir 9 coca-colas
        System.out.println("quantidade de banana: " +
                estoque.get("Banana"));

        for (Entry<String, Integer> tupla : estoque.entrySet()) {
            System.out.println("chave: " + tupla.getKey());
            System.out.println("Valor: " + tupla.getValue());
        }

        Integer valorBanana = estoque.get("Banana");
        estoque.put("Banana", valorBanana - 2);
        estoque.put("Banana", estoque.get("Banana") - 2);


    }
}
