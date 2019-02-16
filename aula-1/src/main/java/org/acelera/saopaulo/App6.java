package org.acelera.saopaulo;

public class App6 {
	public static void main(String[] args) {

		Operacao<Integer, Integer> soma = (a, b) -> {
			return a + b;
		};
		soma.operar(5, 6);

		Operacao<Integer, Integer> subtracao = (a, b) -> {
			return a - b;
		};
		soma.operar(5, 6);

		Operacao<Integer, Integer> multiplicacao = (a, b) -> {return a * b;	};
		soma.operar(5, 6);

		Operacao<Integer, Integer> divisao = (a, b) -> {
			if (b != 0) {
				return a / b;
			} else {
				throw new ArithmeticException("Não é possível realizar divisões por zero !");
			}
		};

		divisao.operar(5, 6);
	}
}
