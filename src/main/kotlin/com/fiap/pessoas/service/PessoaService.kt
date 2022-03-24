package com.fiap.pessoas.service

import com.fiap.pessoas.dto.CreatePessoaDTO
import com.fiap.pessoas.dto.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {

    fun insert(createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO>
    fun list (): Flux<PessoaDTO>


}