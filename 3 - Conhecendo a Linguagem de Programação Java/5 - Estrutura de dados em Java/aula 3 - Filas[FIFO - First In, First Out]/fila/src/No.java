public class No {

    private Object conteudoDoNo;
    private No referenciaDoNo;

    public No() {
    }

    public No(Object conteudo) {
        this.conteudoDoNo = conteudo;
        this.referenciaDoNo = null;
    }

    public Object getConteudoDoNo() {
        return conteudoDoNo;
    }

    public void setConteudoDoNo(Object conteudo) {
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
