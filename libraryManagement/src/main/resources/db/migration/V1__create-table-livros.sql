CREATE TABLE livros(

id BIGINT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(256) not null,
ISBN BIGINT not null,
autor VARCHAR(256) not null,
ano_publicacao BIGINT not null,
preco BIGINT not null,
categoria VARCHAR(256) not null,
disponivel BOOLEAN not null

);

CREATE TABLE usuario(
  
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(256) not null,
  cpf BIGINT not null,
  cep BIGINT not null,
  endereco VARCHAR(256) not null,
  email VARCHAR(256) not null
  
  
);

