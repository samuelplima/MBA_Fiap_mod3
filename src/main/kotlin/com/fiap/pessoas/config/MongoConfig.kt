package com.fiap.pessoas.config

import com.fiap.pessoas.repository.PessoaRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

class MongoConfig {

    @Configuration
    @EnableReactiveMongoRepositories(basePackageClasses = [PessoaRepository::class])
    class MongoConfig : AbstractReactiveMongoConfiguration(){

        override fun getDatabaseName() = "MongoDatabase"

        override fun reactiveMongoClient(): MongoClient = mongoCliente()

        @Bean
        fun mongoCliente(): MongoClient = MongoClients.create()

        override fun reactiveMongoTemplate(
                databaseFactory: ReactiveMongoDatabaseFactory,
                mongoConverter: MappingMongoConverter
        ) = ReactiveMongoTemplate(mongoCliente(), databaseName)

    }


}