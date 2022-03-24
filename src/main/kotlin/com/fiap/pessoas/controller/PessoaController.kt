package com.fiap.pessoas.controller

import com.fiap.pessoas.dto.CreatePessoaDTO
import com.fiap.pessoas.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pessoas")
class PessoaController(private val pessoaService: PessoaService) {

    @GetMapping
    fun list() = pessoaService.list()

    @PostMapping
    fun insert(@RequestBody createPessoaDTO: CreatePessoaDTO) = pessoaService.insert(createPessoaDTO)


}