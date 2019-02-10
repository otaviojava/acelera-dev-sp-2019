package org.aceleradev.saopaulo.MathOperations.MainApplication;

import org.aceleradev.saopaulo.MathOperations.Interface.Operator;
import org.aceleradev.saopaulo.MathOperations.Addition;

public class Main {

    public static void main(String[] args) {

        Operator add = new Addition();

        System.out.println( add.opera(1, 2) );
        System.out.println( add.opera(0,4) );


    }
}
