import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Carro> listaDeCarros = new ArrayList<>();

        listaDeCarros.add(new Carro("Ford"));
        listaDeCarros.add(new Carro("Chevrolet"));
        listaDeCarros.add(new Carro("Volkswagen"));

        System.out.println(listaDeCarros.contains(new Carro("Ford")));

        System.out.println(new Carro("Ford").hashCode());
    }
}