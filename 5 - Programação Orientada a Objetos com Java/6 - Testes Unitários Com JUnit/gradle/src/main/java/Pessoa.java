import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private String nome;
    private LocalDate dataDeNascimento;

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public int calcularIdade() {
        return (int) ChronoUnit.YEARS.between(this.dataDeNascimento, LocalDate.now());
    }
}
