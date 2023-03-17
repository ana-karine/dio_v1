package br.com.dio.exercicios.loops;

import java.util.Scanner;

/*
Faça um programa que peça uma nota entre 0 e 10.
Caso o usuário informe um valor inválido, exiba uma
mensagem de alerta.

Obs.: a mensagem de alerta deverá persistir enquanto o
usuário não informar um valor válido
*/

public class Ex2_Nota {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nota;

        System.out.println("Nota: ");
        nota = scan.nextInt();

        while(nota < 0 | nota > 10) {
            System.out.println("Nota Inválida! Digite novamente: ");
            nota = scan.nextInt();
        }

    }

}