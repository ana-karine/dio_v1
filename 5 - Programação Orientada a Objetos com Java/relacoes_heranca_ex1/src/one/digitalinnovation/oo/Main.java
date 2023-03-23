package one.digitalinnovation.oo;

class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        // Upcasting (subir a hierarquia): quando uma superclasse recebe uma referência da subclasse
        Funcionario gerente1 = new Gerente();
        Funcionario vendedor1 = new Vendedor();
        Funcionario faxineiro1 = new Faxineiro();

        // DownCasting (descer a hierarquia): quando uma subclasse recebe uma referência de uma superclasse
        Gerente gerente2 = (Gerente) new Funcionario();
        Vendedor vendedor2 = (Vendedor) new Funcionario();
        Faxineiro faxineiro2 = (Faxineiro) new Funcionario();
    }
}
