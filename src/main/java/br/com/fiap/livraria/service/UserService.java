package br.com.fiap.livraria.service;

import br.com.fiap.livraria.model.dto.AuthDTO;
import br.com.fiap.livraria.model.dto.JwtDTO;
import br.com.fiap.livraria.model.dto.UserCreateDTO;
import br.com.fiap.livraria.model.dto.UserDTO;

public interface UserService {

    UserDTO create(UserCreateDTO userCreateDTO);
    JwtDTO login(AuthDTO authDTO);

}
