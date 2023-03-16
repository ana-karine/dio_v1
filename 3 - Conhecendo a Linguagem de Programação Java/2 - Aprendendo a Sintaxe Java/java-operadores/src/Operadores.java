public class Operadores {
    public static void main(String[] args) {
        
        // Relacionais
        String nomeUm = "Ana";
        String nomeDois = new String("Ana");

        System.out.println(nomeUm == nomeDois); // false
        System.out.println(nomeUm.equals(nomeDois)); // true (equals: compara conteúdos de objetos)


        // Concatenação
        String concatenacao = "?";

        concatenacao = 1 + 1 + 1 + "1";
        System.out.println(concatenacao); // 31

        concatenacao = 1 + "1" + 1 + 1;
        System.out.println(concatenacao); // 1111

        concatenacao = 1 + "1" + 1 + "1";
        System.out.println(concatenacao); // 1111

        concatenacao = "1" + 1 + 1 + 1;
        System.out.println(concatenacao); // 1111

        concatenacao = "1" + (1 + 1 + 1);
        System.out.println(concatenacao); // 13
    }
}
