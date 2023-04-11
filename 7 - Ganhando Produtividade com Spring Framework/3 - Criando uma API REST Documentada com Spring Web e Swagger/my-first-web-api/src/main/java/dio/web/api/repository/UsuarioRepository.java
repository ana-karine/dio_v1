package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) {
        /*if(usuario.getLogin()==null)
            throw new BusinessException("O campo login é obrigatório");*/

        if(usuario.getLogin()==null)
            throw new CampoObrigatorioException("login");

        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");

        System.out.println("SAVE - Recebendo o usuário " + usuario + " na camada de repositório");
        System.out.println(usuario);
    }

    public void update(Usuario usuario) {
        System.out.println("UPDATE - Recebendo o usuário " + usuario + " na camada de repositório");
        System.out.println(usuario);
    }

    public void delete(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }

    public List<Usuario> getAll() {
        System.out.println("GET - Listando todos os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("ana","password"));
        usuarios.add(new Usuario("karine","masterpass"));
        return usuarios;
    }

    public Usuario getByUsername(String username) {
        System.out.println("GET/username - Recebendo o username para localizar um usuário");
        return new Usuario("ana","password");
    }

    /*public Usuario getById(Integer id) {
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        return new Usuario("karine","masterpass");
    }*/

}
