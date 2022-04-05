package br.com.fiap.livraria.dto;

import br.com.fiap.livraria.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    public LivroDTO(Livro livro) {
    }

    private Integer id;
    private String isbn;
    private String titulo;
    private String autor;
    private BigDecimal preco;

}
