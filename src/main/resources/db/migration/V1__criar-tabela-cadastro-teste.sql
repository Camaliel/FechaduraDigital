CREATE DATABASE moradores_teste;
CREATE DATABASE administrador_teste;

CREATE TABLE cadastro-teste (
  nome VARCHAR(80) NOT NULL,
  nome_do_meio VARCHAR(80),
  ultimo_nome VARCHAR(80),
  chefe_familia VARCHAR(3),
  parentesco VARCHAR(10),
  cpf VARCHAR(12) primary key,
  tel INT,
  senha INT
);

CREATE TABLE moradores_teste.tokens_teste (
 parentesco varchar(10),
 token VARCHAR(6) NOT NULL primary key,
 chefe_familia VARCHAR(3),
 nome varchar(15)
);

CREATE TABLE administrador.tokens-teste (
 id INT
 parentesco varchar(10),
 token VARCHAR(6) primary key,
 chefe_familia VARCHAR(3),
 nome varchar(15)
);

CREATE TABLE administrador_teste.tokens_teste (
 id INT,
 parentesco varchar(10),
 token VARCHAR(6) primary key,
 chefe_familia VARCHAR(3),
 nome varchar(15)
 );

CREATE TABLE moradores_teste.tbl_consultas_teste (
 nome VARCHAR(50),
 nome_do_meio VARCHAR(50),
 ultimo_nome VARCHAR(50),
 token VARCHAR(6) PRIMARY KEY,
 CONSTRAINT fk_token FOREIGN KEY (token) REFERENCES moradores_teste.tokens_teste (token)
 );

 CREATE TABLE moradores_teste.cadastro_teste (
 nome VARCHAR(80) NOT NULL,
 nome_do_meio VARCHAR(80),
 ultimo_nome VARCHAR(80),
 chefe_familia VARCHAR(3),
 parentesco VARCHAR(10),
 cpf VARCHAR(12) primary key,
 tel INT,
 senha INT
 )

 CREATE TABLE moradores_teste.historico_teste (
  token varchar(6) primary key,
  nome varchar(50),
  nome_do_meio varchar(50),
  ultimo_nome varchar(50),
  data varchar(10),
  hora varchar(10),
  parentesco varchar(10),
  status varchar(10)
 );