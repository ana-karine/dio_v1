public class TiposVariaveis {
    public static void main(String[] args) throws Exception {
        
        String meuNome = "Ana Karine"; // a classe String representa texto na aplicação

        double salarioMinimo = 2500;

        short numeroCurto1 = 1;
        int numeroNormal = numeroCurto1;
        short numeroCurto2 = (short)numeroNormal;

        int numero = 5;
        numero = 10;
        System.out.println(numero); // 10

        final double VALOR_DE_PI = 3.14;
    }
}
