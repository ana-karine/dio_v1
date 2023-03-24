package one.digitalinnovation.oo;

public class Classe1 {
    private String atributo1; // dentro da classe
    protected String atributo2; // dentro da classe, subclasses e mesmo pacote
    public String atributo3; // em qualquer local

    private void metodo1() {
        // dentro da classe
    }

    protected void metodo2() {
        // dentro da classe, subclasses e mesmo pacote
    }

    public void metodo3() {
        // em qualquer local
    }
}
