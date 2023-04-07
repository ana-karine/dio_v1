// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.  

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) throws IOException {
		Scanner leitor = new Scanner(System.in).useLocale(Locale.US);

		double[] numeros = new double[3];
		double maior = 0d;
		double soma;
		boolean triangulo = true;

		// System.out.println("Digite o primeiro valor: ");
		double A = leitor.nextDouble();
		numeros[0] = A;

		// System.out.println("Digite o segundo valor: ");
		double B = leitor.nextDouble();

		if (B > A) {
			maior = B;
			numeros[1] = B;
		} else {
			maior = A;
			numeros[1] = A;
			numeros[0] = B;
		}

		// System.out.println("Digite o terceiro valor: ");
		double C = leitor.nextDouble();

		if (C > maior) {
			numeros[2] = C;
		}
		if (C < numeros[0]) {
			numeros[2] = numeros[1];
			numeros[1] = numeros[0];
			numeros[0] = C;
		}
		if (C < numeros[1]) {
			numeros[2] = numeros[1];
			numeros[1] = C;
		}

		soma = numeros[0] + numeros[1];

		if (soma > numeros[2])
			triangulo = false;

		if (!triangulo) {
			Double perimetro = A + B + C;
			System.out.println("Perimetro = " + perimetro);
		} else {
			Double area = ((A + B) * C) / 2;
			System.out.println("Area = " + area);
		}

		leitor.close();
	}
}