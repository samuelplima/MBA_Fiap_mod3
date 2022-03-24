package com.fiap.pessoas.document

import org.springframework.data.annotation.Id

data class PessoaDocument(

    @Id
    val id: String? = null,
    val nome : String


)