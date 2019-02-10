package org.aceleradev.saopaulo.MathOperations;

import org.aceleradev.saopaulo.MathOperations.Interface.Operator;

public class Division implements Operator {

    @Override
    public int opera(int number1, int number2) {

        if(number2 == 0)
        {
            throw new ArithmeticException("Não é possível realizar a operação. \n Motivo: Você está dividindo por zero" );
        }

        return number1 / number2;
    }
}
