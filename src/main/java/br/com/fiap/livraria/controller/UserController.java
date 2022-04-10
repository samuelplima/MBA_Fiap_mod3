package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.dto.AuthDTO;
import br.com.fiap.livraria.model.dto.JwtDTO;
import br.com.fiap.livraria.model.dto.UserCreateDTO;
import br.com.fiap.livraria.model.dto.UserDTO;
import br.com.fiap.livraria.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
@Transactional
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO){
        return userService.create(userCreateDTO);
    }


    @PostMapping("/login")
    public JwtDTO login(@RequestBody AuthDTO authDTO){
        return userService.login(authDTO);
    }
}
