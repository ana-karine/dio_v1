public class Pilha<T> {

    private No<T> referenciaEntradaPilha;

    public Pilha() {
        this.referenciaEntradaPilha = null;
    }

    // IS_EMPTY: verifica se a pilha está "vazia"
    public boolean isEmpty() {
//        if (referenciaEntradaPilha == null) {
//            return true;
//        }
//        return false;

        return referenciaEntradaPilha == null ? true : false;
    }

    // TOP: acessa as informações do elemento posicionado no topo da pilha (sem remover)
    public T top() {
        return (T)referenciaEntradaPilha;
    }

    // PUSH: insere um novo elemento no topo da pilha
    public void push(T numero) {
        No novoNo = new No(numero);

        No referenciaAuxiliar = referenciaEntradaPilha; // guarda a referência de entrada da pilha antes de inserir o novo Nó
        referenciaEntradaPilha = novoNo; // insere o novo Nó
        referenciaEntradaPilha.setReferencia(referenciaAuxiliar); // define a referência de entrada da pilha ao novo Nó
    }

    // POP: remove o elemento do topo da pilha
    public T pop() {

        if (!this.isEmpty()) {
            No referenciaAuxiliar = referenciaEntradaPilha; // guarda a referência de entrada da pilha antes de remover o Nó
            referenciaEntradaPilha = referenciaEntradaPilha.getReferencia(); // define a referência de entrada da pilha ao Nó imediatamente abaixo
            return (T)referenciaAuxiliar; // retorna o Nó a ser excluído
        }
        return null;
    }

    @Override
    public String toString() {

        String stringRetorno = "-------------\n";
        stringRetorno += "    Pilha\n";
        stringRetorno += "-------------\n";

        No referenciaAuxiliar = referenciaEntradaPilha;

        while (true) {
            if (referenciaAuxiliar != null) {
                stringRetorno += "[No{dado=" + referenciaAuxiliar.getDado() + "}]\n";
                referenciaAuxiliar = referenciaAuxiliar.getReferencia();
            } else {
                break;
            }
        }

        stringRetorno += "=============\n";

        return stringRetorno;
    }
}
