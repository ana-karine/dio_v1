package dio.spring.security.jwt.controller;

import dio.spring.security.jwt.model.User;
import dio.spring.security.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    // Postman: localhost:8080/users
    // (body): {"name": "Ana Karine","username": "anakarine", "password": "123456", "roles":["USERS","MANAGERS"]}
    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }
}
