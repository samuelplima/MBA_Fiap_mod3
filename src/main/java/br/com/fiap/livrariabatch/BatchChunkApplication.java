package br.com.fiap.livrariabatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class BatchChunkApplication {

    Logger logger = LoggerFactory.getLogger(BatchChunkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BatchChunkApplication.class, args);
    }

    @Bean
    public FlatFileItemReader<Livro> itemReader(@Value("${file.chunk}") Resource resource){
        return new FlatFileItemReaderBuilder<Livro>()
                .name("Livro item reader")
                .targetType(Livro.class)
                .resource(resource)
                .delimited().delimiter(";").names("titulo", "quantidade")
                .build();
    }

    @Bean
    public ItemProcessor<Livro, Livro> itemProcessor(){
        return (Livro) -> {
            Livro.setTitulo(Livro.getTitulo().toUpperCase());
            Livro.setQuantidade(Livro.getQuantidade());
            return Livro;
        };
    }

    @Bean
    public JdbcBatchItemWriter<Livro> itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Livro>()
                .dataSource(dataSource)
                .sql("insert into TB_LIVRO (titulo, quantidade) values (:titulo, :quantidade)")
                .beanMapped()
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader<Livro> itemReader,
                     ItemProcessor<Livro, Livro> itemProcessor,
                     ItemWriter<Livro> itemWriter){
        return stepBuilderFactory.get("Step chunk file -> jdbc")
                .<Livro, Livro>chunk(2)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   Step step){
        return jobBuilderFactory.get("Job chunk")
                .start(step)
                .build();
    }

}
