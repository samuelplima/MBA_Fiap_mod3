package com.fiap.pessoas.repository

import com.fiap.pessoas.document.PessoaDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository: ReactiveMongoRepository<PessoaDocument, String> {

}