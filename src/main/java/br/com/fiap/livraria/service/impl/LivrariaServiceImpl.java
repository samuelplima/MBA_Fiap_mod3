package br.com.fiap.livraria.service.impl;

import br.com.fiap.livraria.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.dto.LivroDTO;
import br.com.fiap.livraria.dto.UpdatePrecoLivroDTO;
import br.com.fiap.livraria.entity.Livro;
import br.com.fiap.livraria.repository.LivroRepository;
import br.com.fiap.livraria.service.LivrariaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivrariaServiceImpl implements LivrariaService {

    private LivroRepository livroRepository;

    public LivrariaServiceImpl(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @Override
    public List<LivroDTO> listarLivro(String titulo) {
        List<Livro> LivroList;
        if(titulo == null){
            LivroList = livroRepository.findAll();
        } else {
            LivroList = livroRepository.findallByTitulo(titulo);
        }
        return  LivroList
                .stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
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
