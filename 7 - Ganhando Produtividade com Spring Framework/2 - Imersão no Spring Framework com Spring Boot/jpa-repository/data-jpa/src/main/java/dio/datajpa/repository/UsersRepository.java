package dio.datajpa.repository;

import dio.datajpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    //Query Method
    List<Users> findByNameContaining(String name);

    //Query Method
    Users findByUsername(String username);

    //Query Override
    @Query("SELECT u FROM Users u WHERE u.name LIKE %:name%")
    List<Users> filtrarPorNome(@Param("name") String name);
}
