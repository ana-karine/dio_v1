package br.com.dio.collection.streamAPI;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosStreamAPI {

    public static void main(String[] args) {

        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");


        System.out.println("Imprima todos os elementos dessa lista de String: ");

        /*numerosAleatorios.stream().forEach(new Consumer<String>() { // classe anônima e functional interface (Consumer)
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        // numerosAleatorios.stream().forEach(s -> System.out.println(s)); // lambda

        // numerosAleatorios.forEach(s -> System.out.println(s)); // List não precisa de stream para implementar o forEach

        numerosAleatorios.forEach(System.out::println); // reference method


        System.out.println("\nPegue os 5 primeiros números e coloque-os dentro de um Set: ");

        /*numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())// Set não aceita números repetidos
                .forEach(System.out::println);*/

        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());

        System.out.println(numerosAleatorios5Primeiros);


        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros: ");
        
        /*numerosAleatorios.stream()
                .map(new Function<String, Integer>() { // classe anônima e functional interface (Function)
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });*/

        /*numerosAleatorios.stream()
                .map(s -> Integer.parseInt(s)); // lambda*/

        /*numerosAleatorios.stream()
                .map(Integer::parseInt) // reference method
                .collect(Collectors.toList())
                .forEach(System.out::println);*/

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(numerosAleatoriosInteger);


        System.out.println("\nPegue os números pares e maiores que 2 e coloque-os em uma lista: ");

        /*List<Integer> listParesMaioresQue2 = numerosAleatoriosInteger.stream()
                .filter(new Predicate<Integer>() { // classe anônima e functional interface (Predicate)
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());*/

        List<Integer> listParesMaioresQue2 = numerosAleatoriosInteger.stream()
                .filter(i -> (i % 2 == 0 && i > 2)) // lambda
                .collect(Collectors.toList());

        System.out.println(listParesMaioresQue2);


        System.out.println("\nMostre a média dos números: ");

        /*numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String s) {
                        return Integer.parseInt(s);
                    }
                });*/

        /*numerosAleatorios.stream()
                .mapToInt(s -> Integer.parseInt(s));*/

        /*numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double v) {
                        System.out.println(v);
                    }
                });*/

        /*numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(v -> System.out.println(v));*/

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        System.out.println("\nRemova os valores ímpares: ");

        /*numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                if (i % 2 != 0) return true;
                return false;
            }
        });*/

        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));

        System.out.println(numerosAleatoriosInteger);


        // Para você
        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatoriosInteger.stream()
                .skip(3)
                .forEach(System.out::println);


        long countNumerosUnicos = numerosAleatoriosInteger.stream()
                .distinct()
                .count();
        System.out.println("\nRetirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);


        System.out.print("\nMostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);


        System.out.print("\nMostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);;


        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("\nPegue apenas os números pares e some: " + somaDosNumerosPares);


        System.out.println("\nMostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);


        System.out.println("\nAgrupe os valores ímpares múltiplos de 3 ou de 5: ");
//      dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3ou5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3ou5);
    }
}