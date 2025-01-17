CREATE TABLE cursos (
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    creacion varchar(50) not null,
    estado varchar(20) not null,
    autor varchar(50) not null unique,
    curso varchar(50) not null,

    primary key(id)
);