package one.digitalinnovation.gof.Singleton;

/**
 * Singleton "apressado".
 *
 * @autor falvojr
 */

public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        /*if (instancia == null) {
            instancia = new SingletonEager();
        }*/
        return instancia;
    }
}
