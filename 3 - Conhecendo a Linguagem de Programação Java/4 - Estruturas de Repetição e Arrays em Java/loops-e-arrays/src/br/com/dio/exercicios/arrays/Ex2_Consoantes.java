package br.com.dio.exercicios.arrays;

/*
Faça um programa que leia um vetor de 6 caracteres
e retorne quantas consoantes foram lidas.

Obs.: imprima as consoantes
*/

import java.util.Scanner;

public class Ex2_Consoantes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] letras = new String[6];
        int quantidadeConsoantes = 0;

        int count = 0;
        do {
            System.out.println("Letra: ");
            String letra = scan.next();

            if ( !(letra.equalsIgnoreCase("a") |
                    letra.equalsIgnoreCase("e") |
                    letra.equalsIgnoreCase("i") |
                    letra.equalsIgnoreCase("o") |
                    letra.equalsIgnoreCase("u")) )  {
                letras[count] = letra;
                quantidadeConsoantes++;
            }

            count++;

        } while(count < letras.length);

        System.out.print("Consoantes: ");
        for ( String letra  :  letras ) {
            if ( letra != null)
                System.out.print(letra + " ");
        }

        System.out.println("\nQuantidade de consoantes: " + quantidadeConsoantes);
        System.out.println("Quantidade de letras: " + letras.length);
    }
}