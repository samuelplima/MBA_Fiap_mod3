package br.com.fiap.livraria.service.impl;

import br.com.fiap.livraria.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.dto.LivroDTO;
import br.com.fiap.livraria.dto.UpdatePrecoLivroDTO;
import br.com.fiap.livraria.service.LivrariaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrariaServiceImpl implements LivrariaService {

    @Override
    public List<LivroDTO> listarLivro(String titulo) {
        return null;
    }

    @Override
    public LivroDTO buscarLivroPorId(Long id) {
        return null;
    }

    @Override
    public LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO) {
        return null;
    }

    @Override
    public LivroDTO atualizar(Long id, CreateUpdateLivroDTO createUpdateLivroDTO) {
        return null;
    }

    @Override
    public LivroDTO atualizarPreco(Long id, UpdatePrecoLivroDTO updatePrecoLivroDTO) {
        return null;
    }

    @Override
    public void deletarLivro(Long id) {

    }
}
