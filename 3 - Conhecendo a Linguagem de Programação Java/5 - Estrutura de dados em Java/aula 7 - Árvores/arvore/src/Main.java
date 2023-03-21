public class Main {
    public static void main(String[] args) {

        ArvoreBinaria<Arvore> arvoreBinaria = new ArvoreBinaria<>();

        arvoreBinaria.inserir(new Arvore(13));
        arvoreBinaria.inserir(new Arvore(10));
        arvoreBinaria.inserir(new Arvore(25));
        arvoreBinaria.inserir(new Arvore(2));
        arvoreBinaria.inserir(new Arvore(12));
        arvoreBinaria.inserir(new Arvore(20));
        arvoreBinaria.inserir(new Arvore(31));
        arvoreBinaria.inserir(new Arvore(29));

        arvoreBinaria.exibirPreOrdem();
        arvoreBinaria.exibirInOrdem();
        arvoreBinaria.exibirPosOrdem();
    }
}