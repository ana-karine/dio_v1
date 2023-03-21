public class ArvoreBinaria<T extends Comparable<T>> {

    private NoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        NoArvore<T> novoNo = new NoArvore<>(conteudo);

        raiz = inserir(raiz, novoNo);
    }

    private NoArvore<T> inserir(NoArvore<T> atual, NoArvore<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsquerdo(inserir(atual.getNoEsquerdo(), novoNo));
        } else {
            atual.setNoDireito(inserir(atual.getNoDireito(), novoNo));
        }

        return atual;
    }

    public void exibirPreOrdem() {
        System.out.println("\nExibindo PreOrdem");

        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(NoArvore<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsquerdo());
            exibirPreOrdem(atual.getNoDireito());
        }
    }

    public void exibirInOrdem() {
        System.out.println("\nExibindo InOrdem");

        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(NoArvore<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsquerdo());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDireito());
        }
    }

    public void exibirPosOrdem() {
        System.out.print("\nExibindo PosOrdem\n");

        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(NoArvore<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsquerdo());
            exibirPosOrdem(atual.getNoDireito());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void remover (T conteudo) {
        try {
            NoArvore<T> atual = this.raiz;
            NoArvore<T> pai = null;
            NoArvore<T> filho = null;
            NoArvore<T> temp = null;

            if (atual == null) {
                System.out.println("Conteudo não encontrado - bloco try");
            }

            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;

                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsquerdo();
                } else {
                    atual = atual.getNoDireito();
                }
            }

            if (pai == null) {
                if (atual.getNoDireito() == null) {
                    this.raiz = atual.getNoEsquerdo();
                } else if (atual.getNoEsquerdo() == null) {
                    this.raiz = atual.getNoDireito();
                } else {
                    for (
                            temp = atual, filho = atual.getNoEsquerdo();
                            filho.getNoDireito() != null;
                            temp = filho, filho = filho.getNoEsquerdo()
                    ) {
                        if (filho != atual.getNoEsquerdo()) {
                            temp.setNoDireito(filho.getNoEsquerdo());
                            filho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }
                    }
                    filho.setNoDireito(raiz.getNoDireito());
                    raiz = filho;
                }
            } else if (atual.getNoDireito() == null) {
                if (pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoEsquerdo());
                } else {
                    pai.setNoDireito(atual.getNoEsquerdo());
                }
            } else if (atual.getNoEsquerdo() == null) {
                if (pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoDireito());
                } else {
                    pai.setNoDireito(atual.getNoDireito());
                }
            } else {
                for (
                        temp = atual, filho = atual.getNoEsquerdo();
                        filho.getNoDireito() != null;
                        temp = filho, filho = filho.getNoDireito()

                ) {
                    if (filho != atual.getNoEsquerdo()) {
                        temp.setNoDireito(filho.getNoEsquerdo());
                        filho.setNoEsquerdo(atual.getNoEsquerdo());
                    }
                    filho.setNoDireito(atual.getNoDireito());

                    if (pai.getNoEsquerdo() == atual) {
                        pai.setNoEsquerdo(filho);
                    } else {
                        pai.setNoDireito(filho);
                    }
                }
            }
        } catch (NullPointerException erro) {
            System.out.println("Conteudo não encontrado - bloco catch");
        }
    }
}
