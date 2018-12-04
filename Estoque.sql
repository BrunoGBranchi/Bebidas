create database estoque;
use estoque;

create table usuarios(
	
    id bigint primary key not null auto_increment,
    nome varchar(45),
    usuario varchar(45),
    senha varchar(45)

);

select * from usuarios;