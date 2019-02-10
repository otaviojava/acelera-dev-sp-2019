package org.aceleradev.saopaulo.MathOperations;

import org.aceleradev.saopaulo.MathOperations.Interface.Operator;

public class Addition implements Operator {
    @Override
    public int opera(int number1, int number2) {

        return number1 + number2;
    }
}
