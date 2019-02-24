package org.acelera.saopaulo.type;

public class CPF {

    private final  String value;

    private CPF(String value) {

        this.value = value;
    }

    public static CPF of(String valor) {
        //validacao
        return new CPF(valor);
    }


}
