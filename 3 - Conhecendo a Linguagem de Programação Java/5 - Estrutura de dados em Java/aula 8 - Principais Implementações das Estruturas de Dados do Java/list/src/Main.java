import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Carro> listaDeCarros = new ArrayList<>();

        listaDeCarros.add(new Carro("Ford"));
        listaDeCarros.add(new Carro("Chevrolet"));
        listaDeCarros.add(new Carro("Fiat"));
        listaDeCarros.add(new Carro("Peugeot"));

        System.out.println(listaDeCarros.contains(new Carro("Ford")));

        System.out.println(listaDeCarros.get(2));

        System.out.println(listaDeCarros.indexOf(new Carro("Fiat")));

        System.out.println(listaDeCarros.remove(2));
        System.out.println(listaDeCarros);

    }
}