package com.fiap.pessoas.service.impl

import com.fiap.pessoas.document.PessoaDocument
import com.fiap.pessoas.dto.CreatePessoaDTO
import com.fiap.pessoas.dto.PessoaDTO
import com.fiap.pessoas.repository.PessoaRepository
import com.fiap.pessoas.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(private val pessoaRepository: PessoaRepository) : PessoaService {

    override fun insert(createPessoaDTO: CreatePessoaDTO) = Mono.just(createPessoaDTO)
            .map { PessoaDocument(nome = it.nome) }
            .flatMap { pessoaRepository.save(it) }
            .map { PessoaDTO(id = it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), nome = it.nome ) }


    override fun list(): Flux<PessoaDTO> = pessoaRepository.findAll()
            .map { PessoaDTO(id = it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), nome = it.nome) }


}