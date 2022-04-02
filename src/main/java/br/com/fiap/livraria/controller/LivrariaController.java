package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.dto.LivroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("livros")
public class LivrariaController {

    @GetMapping
    public List<LivroDTO> listarLivros(){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setAutor("José da silva");
        livroDTO.setIsbn("123456");
        livroDTO.setPreco(BigDecimal.valueOf(70.50));
        livroDTO.setTitulo("Aprendendo Spring");

        List<LivroDTO> listaLivros = new ArrayList<>();
        listaLivros.add(livroDTO);

        return listaLivros;
    }



}
