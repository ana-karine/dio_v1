public class No {

    private String conteudoDoNo;
    private No referenciaDoProximoNo;

    public No(String conteudo) {
        this.conteudoDoNo = conteudo;
        this.referenciaDoProximoNo = null;
    }

    public String getConteudoDoNo() {
        return conteudoDoNo;
    }

    public void setConteudoDoNo(String conteudo) {
        this.conteudoDoNo = conteudo;
    }

    public No getReferenciaDoProximoNo() {
        return referenciaDoProximoNo;
    }

    public void setReferenciaDoProximoNo(No referencia) {
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
