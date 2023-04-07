// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.  

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Quiz quiz = new Quiz();
        quiz.questions();
    }

    static class Quiz {

        Scanner sc = new Scanner(System.in);

        String AN1, AN2 = "", AN3;
        String animal;

        void questions() {
            // System.out.println("Digite a primeira palavra:\nvertebrado\ninvertebrado");
            AN1 = sc.nextLine();

            if (AN1.equals("vertebrado")) {
                // System.out.println("\nDigite a segunda palavra:\nave\nmamifero");
                AN2 = sc.nextLine();
            } else {
                // System.out.println("\nDigite a segunda palavra:\ninseto\nanelideo");
                AN2 = sc.nextLine();
            }

            switch (AN2) {
                case "ave": {
                    // System.out.println("\nDigite a terceira palavra:\ncarnivoro\nonivoro");
                    AN3 = sc.nextLine();

                    if (AN3.equals("carnivoro"))
                        System.out.println("\naguia");
                    else
                        System.out.println("\npomba");
                    break;
                }
                case "mamifero": {
                    // System.out.println("\nDigite a terceira palavra:\nonivoro\nherbivoro");
                    AN3 = sc.nextLine();

                    if (AN3.equals("onivoro"))
                        System.out.println("\nhomem");
                    else
                        System.out.println("\nvaca");
                    break;
                }
                case "inseto": {
                    // System.out.println("\nDigite a terceira palavra:\nhematofago\nherbivoro");
                    AN3 = sc.nextLine();

                    if (AN3.equals("hematofago"))
                        System.out.println("\npulga");
                    else
                        System.out.println("\nlagarta");
                    break;
                }
                case "anelideo": {
                    // System.out.println("\nDigite a terceira palavra:\nhematofago\nonivoro");
                    AN3 = sc.nextLine();

                    if (AN3.equals("hematofago"))
                        System.out.println("\nsanguessuga");
                    else
                        System.out.println("\nminhoca");
                    break;
                }
                default:
                    // System.out.println("\nDigite o nome corretamente");
                    sc.close();
            }
        }
    }
}