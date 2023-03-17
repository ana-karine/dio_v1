package br.com.dio.exercicios.loops;

import java.util.Scanner;

/*
Desenvolva um gerador de tabuada de multiplicação.
O usuário deverá informar de qual número (inteiro entre 1 e 10)
deseja ver a tabuada.

A saída deverá ser conforme o exemplo abaixo:

Tabuada de 5:
5 X 1 = 5
5 X 2 = 10
...
5 X 10 = 50
*/

public class Ex5_Tabuada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Tabuada: ");
        int numero = scan.nextInt();

        System.out.println("Tabuada de " + numero);
        for(int i = 1; i <= 10; i = i + 1) {
            System.out.println(numero + " X " + i + " = " + (numero * i));
        }
    }
}