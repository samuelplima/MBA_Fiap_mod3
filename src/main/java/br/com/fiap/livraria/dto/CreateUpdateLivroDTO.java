package br.com.fiap.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateLivroDTO {

    private String isbn;
    private String titulo;
    private String autor;
    private BigDecimal preco;

}
