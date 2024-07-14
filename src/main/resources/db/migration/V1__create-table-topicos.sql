create table topicosforum(

    id bigint not null auto_increment,

    titulo varchar(100) not null unique,
    mensagem varchar (500) not null unique,
    data datetime not null,
    status varchar (100) not null,
    autor varchar (100) not null,
    curso varchar (100) not null,

    primary key(id)
);