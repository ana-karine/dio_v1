import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Carro> stackDeCarros = new Stack<>();

        stackDeCarros.push(new Carro("Ford"));
        stackDeCarros.push(new Carro("Chevrolet"));
        stackDeCarros.push(new Carro("Fiat"));
        System.out.println(stackDeCarros);

        System.out.println(stackDeCarros.pop());
        System.out.println(stackDeCarros);

        System.out.println(stackDeCarros.peek());
        System.out.println(stackDeCarros);

        System.out.println(stackDeCarros.empty());
    }
}