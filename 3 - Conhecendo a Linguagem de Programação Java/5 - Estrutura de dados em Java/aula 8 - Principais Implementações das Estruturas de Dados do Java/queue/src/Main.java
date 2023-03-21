import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Carro> queueDeCarros = new LinkedList<>();

        queueDeCarros.add(new Carro("Ford"));
        queueDeCarros.add(new Carro("Chevrolet"));
        queueDeCarros.add(new Carro("Fiat"));

        // add: retorna erro caso não consiga adicionar
        System.out.println(queueDeCarros.add(new Carro("Peugeot")));
        System.out.println(queueDeCarros);

        // offer: retorna false caso não consiga adicionar
        System.out.println(queueDeCarros.offer(new Carro("Renault")));
        System.out.println(queueDeCarros);

        // peek: retorna o primeiro da fila sem remover
        System.out.println(queueDeCarros.peek());
        System.out.println(queueDeCarros);

        // poll: retorna e remove o primeiro da fila
        System.out.println(queueDeCarros.poll());
        System.out.println(queueDeCarros);

        System.out.println(queueDeCarros.isEmpty());

        System.out.println(queueDeCarros.size());
    }
}