package br.com.dio.collection.streamAPI;

import br.com.dio.collection.map.ExercicioProposto03.Contato;

import java.util.*;
import java.util.function.Function;

/*
Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato):

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

public class RefatoracaoExercicioProposto03Map {

    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--"); // HashMap

        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        System.out.println(agenda);

        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        System.out.println("--\tOrdem de inserção\t--"); // LinkedHashMap

        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        System.out.println(agenda1);

        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        System.out.println("--\tOrdem: id\t--"); // TreeMap: é um map sempre ordenado pela chave

        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);

        System.out.println(agenda2);

        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        System.out.println("--\tOrdem: número de telefone\t--");

        // precisamos organizar os valores, logo:
        // Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new ComparatorOrdemNumerica());

        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() { // classe anônima e functional interface (Comparator)
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });*/

        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() { // functional interface (Function)

                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/

        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero() // lambda
        ));

        set.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " + entry.getValue().getNome());
        }


        System.out.println("--\tOrdem: nome do contato\t--");

        // precisamos organizar os valores, logo:
        // Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());

        /*Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() { // classe anônima e functional interface (Comparator)
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
            }
        });*/

        /*Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, String>() { // functional interface (Function)
                    @Override
                    public String apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNome();
                    }
                }
        ));*/

        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNome() // lambda
        ));

        set1.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry : set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}

/*class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}*/

/*class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}*/
