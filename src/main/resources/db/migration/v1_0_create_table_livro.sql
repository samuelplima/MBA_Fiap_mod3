CREATE TABLE TB_LIVRO(
                        ID INTEGER NOT NULL AUTO_INCREMENT,
                        ISBN VARCHAR(50) DEFAULT NULL,
                        TITULO VARCHAR(50) NOT NULL,
                        AUTOR VARCHAR(50) NOT NULL,
                        PRECO BIGINT(20) NOT NULL,
                        PRIMARY KEY (ID)
)