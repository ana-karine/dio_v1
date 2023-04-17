package one.digitalinnovation.gof.Strategy;

public class ComportamentoNomal implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Movendo-se normalmente...");
    }
}
