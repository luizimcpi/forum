create table usuario(
    id bigint not null,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario (id, nome, email) values (1, 'Luiz Silva', 'luiz@email.com');