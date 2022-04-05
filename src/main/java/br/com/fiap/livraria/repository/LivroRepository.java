package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer>{


    @Query("from Livro l " +
            "where l.titulo like %:titulo%")
    List<Livro> findallByTitulo(String titulo);




}
