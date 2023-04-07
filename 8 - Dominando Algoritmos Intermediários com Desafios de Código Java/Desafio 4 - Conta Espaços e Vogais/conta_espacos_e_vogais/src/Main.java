// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.  

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int quantVogais = 0;

    // System.out.println("Digite a frase: ");
    String str = sc.nextLine();

    // pega a quantidade de espaços em branco
    String[] strSplit = str.split(" ");
    int espacosEmBranco = strSplit.length - 1;

    for (String item : strSplit) {

      for (int i = 0; i < item.length(); i++) {
        // pega a quantidade de vogais
        char c = item.toLowerCase().charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
          quantVogais++;
      }
    }

    System.out.println("Espacos em branco: " + espacosEmBranco + " Vogais: " + quantVogais);

    sc.close();
  }
}