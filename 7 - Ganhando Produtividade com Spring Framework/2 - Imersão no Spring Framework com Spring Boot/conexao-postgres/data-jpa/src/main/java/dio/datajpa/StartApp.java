package dio.datajpa;

import dio.datajpa.model.Users;
import dio.datajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// inicialização
@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UsersRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Users user = new Users();
        user.setName("GABRIEL NUNES");
        user.setUsername("gabriel");
        user.setPassword("santos");

        repository.save(user);

        for(Users u: repository.findAll()){
            System.out.println(u);
        }
    }
}
