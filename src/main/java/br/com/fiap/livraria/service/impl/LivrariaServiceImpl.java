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
                .map(livro -> new LivroDTO(livro))
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarLivroPorId(Integer id) {
        Livro livro = livroRepository.getById(id);
        return new LivroDTO(livro);
    }

    @Override
    public LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO) {
        Livro livro = new Livro(createUpdateLivroDTO);
        livro.setTitulo(createUpdateLivroDTO.getTitulo());
        livro.setAutor(createUpdateLivroDTO.getAutor());
        livro.setIsbn(createUpdateLivroDTO.getIsbn());
        livro.setPreco(createUpdateLivroDTO.getPreco());
        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public LivroDTO atualizar(Integer id, CreateUpdateLivroDTO createUpdateLivroDTO) {
        Livro livro = livroRepository.getById(id);
        livro.setTitulo(createUpdateLivroDTO.getTitulo());
        livro.setAutor(createUpdateLivroDTO.getAutor());
        livro.setIsbn(createUpdateLivroDTO.getIsbn());
        livro.setPreco(createUpdateLivroDTO.getPreco());
        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public LivroDTO atualizarPreco(Integer id, UpdatePrecoLivroDTO updatePrecoLivroDTO) {
        Livro livro = livroRepository.getById(id);
        livro.setPreco(updatePrecoLivroDTO.getPreco());
        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public void deletarLivro(Integer id) {
        Livro livro = livroRepository.getById(id);
        livroRepository.delete(livro);
    }
}
