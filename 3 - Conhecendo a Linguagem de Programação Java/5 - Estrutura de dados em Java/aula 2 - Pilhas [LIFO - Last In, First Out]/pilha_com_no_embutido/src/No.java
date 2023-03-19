public class No {

    private int dado;
    private No referencia;

    public No() {
    }

    public No(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getReferencia() {
        return referencia;
    }

    public void setReferencia(No referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
