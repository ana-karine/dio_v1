// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.  

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class DIO {
  public static void main(String[] args) throws IOException {
    Scanner leitor = new Scanner(System.in).useLocale(Locale.US);

    DecimalFormat df = new DecimalFormat("#,###.00");

    double valor1, valor2, valor3;
    double imposto;

    // System.out.println("Digite o valor da renda: ");
    double renda = leitor.nextDouble();

    if (renda > 4500.00) {
      valor1 = (renda - 4500.00) * 0.28;
      valor2 = 1500.00 * 0.18;
      valor3 = 1000.00 * 0.08;
      imposto = valor1 + valor2 + valor3;
      System.out.println("R$ " + df.format(imposto).replace(",", "."));
    } else if (renda > 3000.00 && renda < 4500.01) {
      valor1 = (renda - 3000.00) * 0.18;
      valor2 = 1000.00 * 0.08;
      imposto = valor1 + valor2;
      System.out.println("R$ " + df.format(imposto).replace(",", "."));
    } else if (renda > 2000.00 && renda < 3000.01) {
      imposto = (renda - 2000.00) * 0.08;
      System.out.println("R$ " + df.format(imposto).replace(",", "."));
    } else {
      System.out.println("Isento");
    }

    leitor.close();
  }
}