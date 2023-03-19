public class No<T> {

    private T dado;
    private No<T> referencia;

    public No() {
    }

    public No(T dado) {
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
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
