CREATE TABLE cadastro (
  nome VARCHAR(80) NOT NULL,
  nome_do_meio VARCHAR(80),
  ultimo_nome VARCHAR(80),
  chefe_familia VARCHAR(3),
  parentesco VARCHAR(10),
  cpf VARCHAR(12) primary key,
  tel INT,
  senha INT
);