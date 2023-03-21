import java.util.Objects;

public class Arvore extends ArvoreObjeto<Arvore> {

    Integer meuValor;

    public Arvore(Integer meuValor) {
        this.meuValor = meuValor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arvore arvore = (Arvore) o;
        return Objects.equals(meuValor, arvore.meuValor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meuValor);
    }

    @Override
    public int compareTo(Arvore outro) {
        int i = 0;

        if (this.meuValor > outro.meuValor) {
            i = 1;
        } else if (this.meuValor < outro.meuValor) {
            i = -1;
        }

        return i;
    }

    @Override
    public String toString() {
        return meuValor.toString();
    }
}
