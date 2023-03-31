package one.digitalinnovation;

public class TransferenciaEntreContas {

    public void transferir(Conta contaOrigem, Conta contaDestino, int valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("valor deve ser maior que zero");
        }

        contaOrigem.lancarDebito(valor);
        contaDestino.lancarCredito(valor);
    }
}
