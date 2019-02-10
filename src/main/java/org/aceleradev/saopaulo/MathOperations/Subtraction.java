package org.aceleradev.saopaulo.MathOperations;

import org.aceleradev.saopaulo.MathOperations.Interface.Operator;

public class Subtraction implements Operator {

    @Override
    public int opera(int number1, int number2) {
        return number1 - number2;
    }
}
