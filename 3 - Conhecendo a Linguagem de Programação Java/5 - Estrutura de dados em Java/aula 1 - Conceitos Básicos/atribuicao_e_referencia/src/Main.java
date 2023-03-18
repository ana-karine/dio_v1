public class Main {
    public static void main(String[] args) {

        // Com tipos primitivos, copiamos o valor em memória
        int numeroX = 1;
        int numeroY = numeroX;
        System.out.println("numeroX = " + numeroX + " numeroY = " + numeroY);

        numeroX = 2;
        System.out.println("numeroX = " + numeroX + " numeroY = " + numeroY);

        // Com objetos, copiamos o valor da referência em memória, sem duplicar o objeto
        MeuObjeto meuObjetoX = new MeuObjeto(1);
        MeuObjeto meuObjetoY = meuObjetoX;
        System.out.println("\nmeuObjetoX = " + meuObjetoX + " meuObjetoY = " + meuObjetoY);

        meuObjetoX.setNumero(2);
        System.out.println("meuObjetoX = " + meuObjetoX + " meuObjetoY = " + meuObjetoY);

    }
}