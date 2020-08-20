create table ordem_servico (
	id SERIAL PRIMARY KEY,
	cliente_id int REFERENCES cliente (id) ON UPDATE CASCADE ON DELETE CASCADE,
	descricao varchar(255) not null,
	preco decimal(10,2) not null,
	status varchar(20) not null,
	data_abertura timestamp not null,
	data_finalizacao timestamp
);