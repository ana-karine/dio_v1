public class No<T> {

    private T conteudoDoNo;
    private No<T> referenciaDoNo;

    public No() {
    }

    public No(T conteudo) {
        this.conteudoDoNo = conteudo;
        this.referenciaDoNo = null;
    }

    public T getConteudoDoNo() {
        return conteudoDoNo;
    }

    public void setConteudoDoNo(T conteudo) {
        this.conteudoDoNo = conteudo;
    }

    public No getReferenciaDoNo() {
        return referenciaDoNo;
    }

    public void setReferenciaDoNo(No referencia) {
        this.referenciaDoNo = referencia;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudoDoNo=" + conteudoDoNo +
                '}';
    }
}
