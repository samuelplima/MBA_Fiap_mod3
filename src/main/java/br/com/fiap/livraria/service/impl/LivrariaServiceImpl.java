package br.com.fiap.livraria.service.impl;

import br.com.fiap.livraria.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.model.dto.LivroDTO;
import br.com.fiap.livraria.model.dto.UpdatePrecoLivroDTO;
import br.com.fiap.livraria.model.entity.Livro;
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
    public List<LivroDTO> listarTodos() {
        List<Livro> LivroList;
        LivroList = livroRepository.findAll();
        return LivroList
                .stream()
                .map(livro -> getLivroDTOListar(livro))
                .collect(Collectors.toList());
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
                .map(livro -> getLivroDTOListar(livro))
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarLivroPorId(Integer id) {
        Livro livro = livroRepository.getById(id);
        return getLivroDTOId(livro);
    }


    @Override
    public LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO) {
        Livro livro = new Livro(createUpdateLivroDTO);
        return getLivroDTO(createUpdateLivroDTO, livro);
    }

    @Override
    public LivroDTO atualizar(Integer id, CreateUpdateLivroDTO createUpdateLivroDTO) {
        Livro livro = livroRepository.getById(id);
        return getLivroDTO(createUpdateLivroDTO, livro);
    }

    @Override
    public LivroDTO atualizarPreco(Integer id, UpdatePrecoLivroDTO updatePrecoLivroDTO) {
        Livro livro = livroRepository.getById(id);
        livro.setPreco(updatePrecoLivroDTO.getPreco());
        livroRepository.save(livro);
        return getLivroDTOpreco(livro);
    }

    @Override
    public void deletarLivro(Integer id) {
        Livro livro = livroRepository.getById(id);
        livroRepository.delete(livro);
    }

    private LivroDTO getLivroDTO(CreateUpdateLivroDTO createUpdateLivroDTO, Livro livro) {
        livro.setTitulo(createUpdateLivroDTO.getTitulo());
        livro.setAutor(createUpdateLivroDTO.getAutor());
        livro.setIsbn(createUpdateLivroDTO.getIsbn());
        livro.setPreco(createUpdateLivroDTO.getPreco());
        livroRepository.save(livro);
        return new LivroDTO(livro.getId(),livro.getIsbn(), livro.getAutor(), livro.getTitulo(), livro.getPreco());
    }

    private LivroDTO getLivroDTOId(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getIsbn(), livro.getAutor(), livro.getTitulo(), livro.getPreco());
    }

    private LivroDTO getLivroDTOpreco(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getIsbn(), livro.getAutor(), livro.getTitulo(), livro.getPreco());
    }

    private LivroDTO getLivroDTOListar(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getIsbn(), livro.getAutor(), livro.getTitulo(), livro.getPreco());
    }

}
