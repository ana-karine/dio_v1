// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.  

import java.util.*;

public class DIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalFrutas = 0;
        double precoMorangos = 0d;
        double precoMacas = 0d;
        double precoTotal = 0d;

        // System.out.println("Informe a quantidade em kg de morangos: ");
        int morangos = input.nextInt();

        // System.out.println("Informe a quantidade em kg de maçãs: ");
        int macas = input.nextInt();

        totalFrutas = morangos + macas;

        if (morangos > 5) {
            precoMorangos = morangos * 2.20;
        } else {
            precoMorangos = morangos * 2.50;
        }

        if (macas > 5) {
            precoMacas = macas * 1.50;
        } else {
            precoMacas = macas * 1.80;
        }

        precoTotal = precoMorangos + precoMacas;

        if (totalFrutas > 8 || precoTotal > 25.00) {
            precoTotal = precoTotal * 0.90;
        }

        // System.out.println("Valor a ser pago: R$ " + precoTotal);
        System.out.println(precoTotal);

        input.close();
    }
}