package br.com.fiap.livraria.service;

import br.com.fiap.livraria.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.dto.LivroDTO;
import br.com.fiap.livraria.dto.UpdatePrecoLivroDTO;

import java.util.List;

public interface LivrariaService {

    List<LivroDTO> listarLivro(String titulo);

    LivroDTO buscarLivroPorId(Long id);

    LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO);

    LivroDTO atualizar(Long id, CreateUpdateLivroDTO createUpdateLivroDTO);

    LivroDTO atualizarPreco(Long id, UpdatePrecoLivroDTO updatePrecoLivroDTO);

    void deletarLivro(Long id);


}
