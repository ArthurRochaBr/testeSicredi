Aplicação desenvolvida para o teste do Sicredi visando desenvolver uma API de votação de assembléia.
Para tal criei um banco local chamado sicredi no MySQL Workbench para persistir os dados da aplicação segue abaixo os scripts de criação das tabelas, gostaria de ter mais tempo para desenvolver as atividades adicionais pois acredito que conseguiria as desenvolver.

create database sicredi;

use sicredi;

create table pauta(
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(500) NOT NULL,
  descricao VARCHAR(5000) NOT NULL,
  inicio timestamp,
  encerramento timestamp,
  status char
);

create table associado(
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(500) NOT NULL,
  cpf VARCHAR(11) NOT NULL
);

create table voto(
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  id_pauta int NOT NULL,
  id_associado int NOT NULL,
  voto char NOT NULL
);

