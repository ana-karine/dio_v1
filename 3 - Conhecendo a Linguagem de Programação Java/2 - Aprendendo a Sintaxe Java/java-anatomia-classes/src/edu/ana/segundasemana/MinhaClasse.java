package edu.ana.segundasemana;
public class MinhaClasse {
    public static void main (String[] args) {
        
        String primeiroNome = "Ana";
        String segundoNome = "Karine";

        String imprimirNome = exibirNome(primeiroNome, segundoNome);
        
        System.out.println(imprimirNome);
    }

    public static String exibirNome (String primeiroNome, String segundoNome) {
        return primeiroNome.concat(" ").concat(segundoNome);
    }
}
