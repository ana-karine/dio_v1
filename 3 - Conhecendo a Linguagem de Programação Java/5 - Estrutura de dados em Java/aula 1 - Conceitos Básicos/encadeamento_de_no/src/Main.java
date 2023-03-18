public class Main {
    public static void main(String[] args) {

        System.out.println("Instanciando os Nós 1, 2 e 3: ");

        No no1 = new No("Conteúdo do nó 1");
        System.out.println("Nó 1: " + no1);

        No no2 = new No("Conteúdo do nó 2");
        System.out.println("Nó 2: " + no2);

        No no3 = new No("Conteúdo do nó 3");
        System.out.println("Nó 3: " + no3);

        System.out.println("\n_________________________________________");

        System.out.println("\nReferência do nó 1 apontando para o nó 2 e");
        System.out.println("referência do nó 2 apontando para o null");
        no1.setReferenciaDoProximoNo(no2);

        System.out.println("Nó 1: " + no1);
        System.out.println("Nó 2: " + no2);

        System.out.println("\n_________________________________________");

        System.out.println("\nReferência do nó 1 apontando para o nó 2,");
        System.out.println("referência do nó 2 apontando para o nó 3 e");
        System.out.println("referência do nó 3 apontando para o null");
        no2.setReferenciaDoProximoNo(no3);

        System.out.println("Nó 1: " + no1);
        System.out.println("Nó 2: " + no2);
        System.out.println("Nó 3: " + no3);

        System.out.println("\n_________________________________________");

        System.out.println("\nEncadeamento de nós: ");
        System.out.println(no1);
        System.out.println(no1.getReferenciaDoProximoNo());
        System.out.println(no1.getReferenciaDoProximoNo().getReferenciaDoProximoNo());
        System.out.println(no1.getReferenciaDoProximoNo().getReferenciaDoProximoNo().getReferenciaDoProximoNo());
    }
}