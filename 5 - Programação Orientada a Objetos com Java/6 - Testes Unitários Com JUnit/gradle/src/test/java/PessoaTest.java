import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    public void validarCalculoDeIdade() {
        Pessoa pessoa = new Pessoa("ana", LocalDate.of(1981, 8, 13));
        Assert.assertEquals(41, pessoa.calcularIdade());
    }
}
