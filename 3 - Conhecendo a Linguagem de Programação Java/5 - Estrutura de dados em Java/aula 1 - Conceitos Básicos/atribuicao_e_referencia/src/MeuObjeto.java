public class MeuObjeto {

    Integer numero;

    public MeuObjeto(Integer num) {
        this.numero = num;
    }

    public void setNumero(Integer num) {
        this.numero = num;
    }

    @Override
    public String toString() {
        return this.numero.toString();
    }
}
