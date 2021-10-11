
create table products.product(
	id integer not null auto_increment,
	nome varchar(100) not null,
	product_identifier varchar not null,
	nome varchar(100) not null,
	descricao varchar not null,
	preco float not null,
	category_id integer REFERENCES products.category(id),
	primary key(id)
);


