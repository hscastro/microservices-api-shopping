create schema if not exists shopping;

create table shopping.shop(
	id integer not null auto_increment,
	user_identifier varchar(100) not null,
	date timestamp not null,
	total float not null,
	primary key(id)
);

create table shopping.item(
	shop_id integer REFERENCES shopping.shop(id),
	product_identifier varchar(100) not null,
	price float not null
);

