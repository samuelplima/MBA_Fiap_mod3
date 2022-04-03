package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.dto.LivroDTO;
import br.com.fiap.livraria.dto.UpdatePrecoLivroDTO;
import br.com.fiap.livraria.service.LivrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("livros")
public class LivrariaController {

    //injeção de dependencia
    private LivrariaService livrariaService;

    //injeção de dependencia
    public LivrariaController(LivrariaService livrariaService) {
        this.livrariaService = livrariaService;
    }

    @GetMapping
    public List<LivroDTO> getLivros(
            @RequestParam String titulo
    ) {
        return livrariaService.listarLivro(titulo);
    }

    @GetMapping("{isbn}")
    public LivroDTO getLivroById(
            @PathVariable(name = "id") Long id
    ) {
        return livrariaService.buscarLivroPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO createLivro(
            @RequestBody CreateUpdateLivroDTO novoLivroDTO
    ) {
        return livrariaService.criar(novoLivroDTO);
    }

    @PutMapping("{isbn}")
    public LivroDTO updateLivro(
            @RequestBody CreateUpdateLivroDTO novoLivroDTO,
            @PathVariable Long id
    ) {
        return livrariaService.atualizar(id, novoLivroDTO);
    }

    @PatchMapping("{isbn}")
    public LivroDTO updatePreco(
            @RequestBody UpdatePrecoLivroDTO updatePrecoLivroDTO,
            @PathVariable Long id
    ) {
        return livrariaService.atualizarPreco(id, updatePrecoLivroDTO);
    }

    @DeleteMapping("{isbn}")
    public void deleteLivro(
            @PathVariable Long id
    ) {
        livrariaService.deletarLivro(id);
    }


}
