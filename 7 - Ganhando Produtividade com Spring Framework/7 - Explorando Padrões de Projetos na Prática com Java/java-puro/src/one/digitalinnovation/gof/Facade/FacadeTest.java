package one.digitalinnovation.gof.Facade;

import one.digitalinnovation.gof.Strategy.*;

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.migrarCliente("Ana", "60000000");

    }
}