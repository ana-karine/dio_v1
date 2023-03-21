public class NoArvore<T extends Comparable<T>> {

    private T conteudo;
    private NoArvore<T> NoEsquerdo;
    private NoArvore<T> NoDireito;

    public NoArvore() {
    }

    public NoArvore(T conteudo) {
        this.conteudo = conteudo;
        NoEsquerdo = NoDireito = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoArvore<T> getNoEsquerdo() {
        return NoEsquerdo;
    }

    public void setNoEsquerdo(NoArvore<T> noEsquerdo) {
        NoEsquerdo = noEsquerdo;
    }

    public NoArvore<T> getNoDireito() {
        return NoDireito;
    }

    public void setNoDireito(NoArvore<T> noDireito) {
        NoDireito = noDireito;
    }

    @Override
    public String toString() {
        return "NoBinario{" +
                "conteudo=" + conteudo +
                '}';
    }
}
