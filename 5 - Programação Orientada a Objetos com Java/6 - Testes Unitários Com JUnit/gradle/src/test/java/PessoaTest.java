import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    public void validarCalculoDeIdade() {
        Pessoa pessoa = new Pessoa("ana", LocalDate.of(1981, 8, 13));
        Assertions.assertEquals(41, pessoa.calcularIdade());
    }
}
