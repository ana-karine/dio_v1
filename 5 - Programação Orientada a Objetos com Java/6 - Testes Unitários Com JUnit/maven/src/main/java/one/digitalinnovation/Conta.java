package one.digitalinnovation;

public class Conta {

    private String numeroConta;

    private int saldo;

    public Conta(String numeroConta, int saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void lancarCredito(int valor) {
        this.saldo += valor;
    }

    public void lancarDebito(int valor) {
        this.saldo -= valor;
    }
}
