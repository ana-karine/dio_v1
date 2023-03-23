package one.digitalinnovation.oo;

class Main {
    public static void main(String[] args) {

        ClasseMae[] classes = new ClasseMae[] {new ClasseFilha1(), new ClasseFilha2(), new ClasseMae()};

        for (ClasseMae classe : classes) { // tipo ClasseMae
            classe.metodo1();
        }
//        Método 1 da classe filha 1 ==> polimorfismo
//        Método 1 da classe filha 2 ==> polimorfismo
//        Método 1 da classe mãe

        System.out.println("");

        for (ClasseMae classe : classes) { // tipo ClasseMae
            classe.metodo2();
        }
//        Método 2 da classe mãe (a classe filha 1 não contém método 2)
//        Método 2 da classe filha 2 ==> polimorfismo
//        Método 2 da classe mãe

        System.out.println("");

        ClasseFilha2 classeFilha2 = new ClasseFilha2();
        classeFilha2.metodo2();
//        Método 2 da classe filha 2 ==> sobrescrita
    }
}