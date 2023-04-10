package dio.datajpa;

import dio.datajpa.model.Users;
import dio.datajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// inicialização
@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UsersRepository repository;

    @Override
    public void run(String... args) throws Exception {
        /*List<Users> users = repository.filtrarPorNome("Ana");
        for(Users u: users) {
            System.out.println(u);
        }*/
        List<Users> users = repository.findByNameContaining("Ana");
        for(Users u: users) {
            System.out.println(u);
        }
    }
    /*private void insertUser() {
        Users user = new Users();
        user.setName("GLEYSON SAMPAIO");
        user.setUsername("glysns");
        user.setPassword("dio123");

        repository.save(user);

        for(Users u: repository.findAll()){
            System.out.println(u);
        }
    }*/
}
