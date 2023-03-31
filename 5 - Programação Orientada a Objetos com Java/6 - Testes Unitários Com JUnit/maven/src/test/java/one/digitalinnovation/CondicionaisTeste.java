package one.digitalinnovation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.*;

public class CondicionaisTeste {

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "ana")
    void validarAlgoSomenteNoUsuarioAna() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void validarAlgoSomenteNoLinux() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnJre(JAVA_17)
    void validarAlgoSomenteNoJre17() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledForJreRange(min = JAVA_11, max = JAVA_17)
    void validarAlgoSomenteNoJreRange() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
