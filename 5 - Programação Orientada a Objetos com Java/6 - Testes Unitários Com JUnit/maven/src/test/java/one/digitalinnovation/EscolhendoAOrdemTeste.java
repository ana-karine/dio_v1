package one.digitalinnovation;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class EscolhendoAOrdemTeste {

    @DisplayName("Teste que valida se o usuário foi criado")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    @DisplayName("C")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    @DisplayName("D")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}

/*@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoAOrdemTeste {

    @Order(4)
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    @Order(3)
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    @Order(2)
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    @Order(1)
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}*/
