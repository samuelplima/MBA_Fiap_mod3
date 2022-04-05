package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.dto.LivroDTO;
import br.com.fiap.livraria.dto.UpdatePrecoLivroDTO;
import br.com.fiap.livraria.service.LivrariaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@Slf4j
@Transactional
public class LivrariaController {

    //injeção de dependencia
    private LivrariaService livrariaService;

    //injeção de dependencia
    public LivrariaController(LivrariaService livrariaService) {
        this.livrariaService = livrariaService;
    }

    @GetMapping(value = "/listarTodos")
    @ResponseBody
    public List<LivroDTO> findAll() {
        return livrariaService.listarTodos();
    }

    @GetMapping(value = "/listarPorTitulo")
    @ResponseBody
    public List<LivroDTO> findByTitulo(
            @RequestParam(required = false, value = "titulo") String titulo
    ) {
        return livrariaService.listarLivro(titulo);
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public LivroDTO getLivroById(
            @PathVariable Integer id
    ) {
        return livrariaService.buscarLivroPorId(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LivroDTO createLivro(
            @RequestBody CreateUpdateLivroDTO novoLivroDTO
    ) {
        return livrariaService.criar(novoLivroDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public LivroDTO updateLivro(
            @PathVariable Integer id,
            @RequestBody CreateUpdateLivroDTO novoLivroDTO
    ) {
        return livrariaService.atualizar(id, novoLivroDTO);
    }

    @PatchMapping("/updatePreco/{id}")
    @ResponseBody
    public LivroDTO updatePreco(
            @PathVariable Integer id,
            @RequestBody UpdatePrecoLivroDTO updatePrecoLivroDTO
    ) {
        return livrariaService.atualizarPreco(id, updatePrecoLivroDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLivro(
            @PathVariable Integer id
    ) {
        livrariaService.deletarLivro(id);
    }


}
