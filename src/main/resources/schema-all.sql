drop table if exists TB_LIVRO;

create table TB_LIVRO(
                         id long auto_increment not null primary key,
                         titulo varchar(100) not null,
                         quantidade int not null
)