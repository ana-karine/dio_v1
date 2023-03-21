import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Carro> setCarro = new HashSet<>();

        setCarro.add(new Carro("Ford"));
        setCarro.add(new Carro("Chevrolet"));
        setCarro.add(new Carro("Fiat"));
        setCarro.add(new Carro("Peugeot"));
        setCarro.add(new Carro("Zip"));
        setCarro.add(new Carro("Alfa Romeo"));

        System.out.println(setCarro);


        Set<Carro> treeSetCarro = new TreeSet<>();

        treeSetCarro.add(new Carro("Ford"));
        treeSetCarro.add(new Carro("Chevrolet"));
        treeSetCarro.add(new Carro("Fiat"));
        treeSetCarro.add(new Carro("Peugeot"));
        treeSetCarro.add(new Carro("Zip"));
        treeSetCarro.add(new Carro("Alfa Romeo"));

        System.out.println(treeSetCarro);

    }
}