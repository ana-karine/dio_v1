public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " dessa lista. Essa lista só vai até o índice " + ultimoIndice);
        }
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    public int size() {
        int tamanhoLista = 0;

        No<T> referenciaAuxiliar = referenciaEntrada;

        while (true) {
            if (referenciaAuxiliar != null) {
                tamanhoLista++;

                if (referenciaAuxiliar.getProximoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if(this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;

        for (int i = 0; i < this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    private No<T> getNo(int index) {

        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noRetorno;
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    public T remove(int index) { // index = 3
        No<T> noRemovido = this.getNo(index); // noRemovido = No[3]

        if (index == 0) {
            referenciaEntrada = noRemovido.getProximoNo(); // passa a referência de entrada para o Nó de índice 1
            return noRemovido.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1); // noAnterior = No[2]

        // noRemovido.getProximoNo() --> noRemovido faz referência ao Nó de índice 4
        // noAnterior.setProximoNo(4); -->  a referência do noAnterior passa a apontar para o Nó de índice 4
        noAnterior.setProximoNo(noRemovido.getProximoNo());

        return noRemovido.getConteudo();
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;

        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += "null";

        return strRetorno;
    }
}
