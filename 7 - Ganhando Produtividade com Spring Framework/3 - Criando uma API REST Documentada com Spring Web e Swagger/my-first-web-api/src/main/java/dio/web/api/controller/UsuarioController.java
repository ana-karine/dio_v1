package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    // Postman: localhost:8080/usuarios
    // (body): {"login": "ana_karine","password": "novasenha"}
    @PostMapping()
    public void post(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    // Postman: localhost:8080/usuarios
    // (body): {"login": "login123","password": "senha123456"}
    @PutMapping()
    public void put(@RequestBody Usuario usuario){
        repository.update(usuario);
    }

    @GetMapping()
    public List<Usuario> getAllUsers() {
        return repository.getAll();
    }

    @GetMapping("/{username}")
    public Usuario getOneUserByUsername(String username) {
        return repository.getByUsername(username);
    }

   /* @GetMapping("/{id}")
    public Usuario getOneUserById(@PathVariable("id") Integer id) {
        return repository.getById(id);
    }*/

    // Postman: localhost:8080/usuarios/123
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }
}
