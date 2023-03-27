package br.com.dio.collection.set;

/*
Dadas as seguintes informações sobre séries favoritas, crie um conjunto
e o ordene exibindo nome - gênero - tempo de episódio:

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comedia, tempoEpisodio: 25
*/

import java.util.*;

public class OrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie : minhasSeries) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem de inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie : minhasSeries1) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem natural (tempoEpisodio)\t--");

        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);

        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem nome/genero/tempoEpisodio\t--");

        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);

        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());


//      Para você:

        System.out.println("--\tOrdem por genero\t--");

        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
        minhasSeries4.addAll(minhasSeries);

        for (Serie serie: minhasSeries4) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem por nome\t--");

        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorNome());
        minhasSeries5.addAll(minhasSeries);

        for (Serie serie: minhasSeries5) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie (String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie outraSerie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), outraSerie.getTempoEpisodio());

        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(outraSerie.getGenero()); // critério de desempate quando 'tempoEpisodio' for igual
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare (Serie serie, Serie outraSerie) {
        int nome = serie.getNome().compareTo(outraSerie.getNome());
        if (nome != 0) return nome;

        int genero = serie.getGenero().compareTo(outraSerie.getGenero());
        if (genero != 0) return genero; // critério de desempate quando 'nome' for igual

        return Integer.compare(serie.getTempoEpisodio(), outraSerie.getTempoEpisodio()); // critério de desempate quando 'nome' e 'genero' forem iguais
    }
}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie serie, Serie outraSerie) {
        int genero = serie.getGenero().compareTo(outraSerie.getGenero());
        if (genero != 0) return genero;

        return serie.getNome().compareTo(outraSerie.getNome()); // critério de desempate quando 'genero' for igual
    }
}

class ComparatorNome implements Comparator<Serie> {

    @Override
    public int compare(Serie serie, Serie outraSerie) {
        int nome = serie.getNome().compareTo(outraSerie.getNome());
        if (nome != 0) return nome;

        return serie.getGenero().compareTo(outraSerie.getGenero()); // critério de desempate quando 'nome' for igual
    }
}

