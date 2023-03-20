public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoDaLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoDaLista = 0;
    }

    public int size() {
        return tamanhoDaLista;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoPosterior();
        }

        return noAuxiliar;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        novoNo.setNoPosterior(null);
        novoNo.setNoAnterior(ultimoNo);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }

        if (ultimoNo != null) {
            ultimoNo.setNoPosterior(novoNo);
        }

        ultimoNo = novoNo;

        tamanhoDaLista++;
    }

    // No[0] = 0, No[1] = 1
    // No[0] = 0, No[1] = 2, No[2] = 1
    public void add(int index, T elemento) { // index = 1, elemento = 2
        NoDuplo<T> noAuxiliar = getNo(index); // noAuxiliar = No[1] = 1
        NoDuplo<T> novoNo = new NoDuplo<>(elemento); // novoNo[?] = 2
        novoNo.setNoPosterior(noAuxiliar); // novoNo[?] = 2 --> No[2] = 1

        if (novoNo.getNoPosterior() != null) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior()); // No[0] = 0 <-- novoNo[?] = 2
            novoNo.getNoPosterior().setNoAnterior(novoNo); // novoNo[?] = 2 <-- No[2] = 1
        } else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0) {
            primeiroNo = novoNo;
        } else {
            novoNo.getNoAnterior().setNoPosterior(novoNo); // No[0] = 0 --> novoNo[?] = 2
        }

        tamanhoDaLista++;
    }

    // No[0] = 0, No[1] = 2, No[2] = 1
    // No[0] = 0, No[1] = 1
    public void remove(int index) { // index = 1
        if (index == 0) {
            primeiroNo = primeiroNo.getNoPosterior();
            if (primeiroNo != null) {
                primeiroNo.setNoAnterior(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index); // noAuxiliar = No[1] = 2
            noAuxiliar.getNoAnterior().setNoPosterior(noAuxiliar.getNoPosterior()); // No[0] = 0 --> No[2] = 1
            if(noAuxiliar != ultimoNo) {
                noAuxiliar.getNoPosterior().setNoAnterior(noAuxiliar.getNoAnterior()); // No[0] = 0 <-- No[2] = 1
            } else {
                ultimoNo = noAuxiliar;
            }
        }

        this.tamanhoDaLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0; i < size(); i++ ) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getNoPosterior();
        }
        strRetorno += "null";

        return strRetorno;
    }
}
