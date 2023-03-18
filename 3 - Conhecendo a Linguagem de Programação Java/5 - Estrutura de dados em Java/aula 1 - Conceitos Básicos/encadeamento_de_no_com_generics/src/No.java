public class No<T> {

    private T conteudoDoNo;
    private No<T> referenciaDoProximoNo;

    public No(T conteudo) {
        this.conteudoDoNo = conteudo;
        this.referenciaDoProximoNo = null;
    }

    public T getConteudoDoNo() {
        return conteudoDoNo;
    }

    public void setConteudoDoNo(T conteudo) {
        this.conteudoDoNo = conteudo;
    }

    public No<T> getReferenciaDoProximoNo() {
        return referenciaDoProximoNo;
    }

    public void setReferenciaDoProximoNo(No<T> referencia) {
        this.referenciaDoProximoNo = referencia;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudoDoNo='" + conteudoDoNo + '\'' +
                ", referenciaDoProximoNo=" + referenciaDoProximoNo +
                '}';
    }
}
