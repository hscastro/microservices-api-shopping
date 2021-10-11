create schema if not exists products;

create table products.category(
	id integer not null auto_increment,
	nome varchar(100) not null,
	primary key(id)
);


