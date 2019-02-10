package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App2 {

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<>();
        frutas.add("Banana");
        frutas.add("Melancia");
        frutas.add("Melancia");
        frutas.add("Melao");
        frutas.add("Morango");


        Set<String> produtos = new HashSet<>();
        produtos.add("Caneta");
        produtos.add("Caneta");
        produtos.add("Notebook");
        produtos.add("mesa");
        produtos.add("Caneca");

        System.out.println("frutas: ");
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        System.out.println("Produtos: ");
        for (String produto : produtos) {
            System.out.println(produto);
        }



    }
}
