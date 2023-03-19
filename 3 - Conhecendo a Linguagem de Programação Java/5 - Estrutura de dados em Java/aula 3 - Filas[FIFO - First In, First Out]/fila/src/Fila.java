public class Fila {
    private No referenciaEntradaFila;

    public Fila() {
        this.referenciaEntradaFila = null;
    }

    // IS_EMPTY: verifica se a fila está "vazia"
    public boolean isEmpty() {
        return referenciaEntradaFila == null ? true : false;
    }

    // FIRST: acessa as informações do primeiro elemento da fila (sem remover)
    public No first() {
        if (!this.isEmpty()) {
            No primeiroNo = referenciaEntradaFila;

            while (true) {
                if (primeiroNo.getReferenciaDoNo() != null) {
                    primeiroNo = primeiroNo.getReferenciaDoNo();
                } else {
                    break;
                }
            }

            return primeiroNo;
        }

        return null;
    }

    // ENQUEUE: insere um novo elemento no final da fila
    public void enqueue(No novoNo) {

        novoNo.setReferenciaDoNo(referenciaEntradaFila); // define a referência de entrada da fila ao novo Nó
        referenciaEntradaFila = novoNo; // define a referência de entrada da fila ao novo Nó
    }

    // DEQUEUE: remove o elemento do final da fila
     public No dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = referenciaEntradaFila; // [i]
            No noAuxiliar = referenciaEntradaFila; // [i-1]

            while (true) {
                if (primeiroNo.getReferenciaDoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getReferenciaDoNo();
                } else {
                    noAuxiliar.setReferenciaDoNo(null);
                    break;
                }
            }

            return primeiroNo;
        }

        return null;
    }

    @Override
    public String toString() {

        String stringRetorno = "";

        No referenciaAuxiliar = referenciaEntradaFila;

        if (referenciaAuxiliar != null) {
            while (true) {
                stringRetorno += "[No{objeto=" + referenciaAuxiliar.getConteudoDoNo() + "}]--->";
                if (referenciaAuxiliar.getReferenciaDoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getReferenciaDoNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }

         return stringRetorno;
    }
}
