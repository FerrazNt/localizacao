create table cidade(
    id_Cidade bigint not null primary key,
    nome varchar(100) not null,
    qtd_habitantes bigint
);

insert into cidade 
    (id_cidade, nome, qtd_habitantes)
values 
    (1,'Serra Talhada', 2980006),
    (2,'Recife',180000000),
    (3, 'Fortaleza', 8000000),
    (4, 'Belo Horizonte', 6000000),
    (5, 'Salvador', 7000000),
    (6, 'Porto Velho', 300000),
    (7, 'Porto Alegre', 5670000),
    (8, 'Natal', 1234567),
    (9, 'Sao Paulo', 12330000),
    (10, 'Rio de Janeiro', 130000000),
    (11, 'Brasilia', 123131313),
    (12, 'Rio Velho', 100000),
    (13, 'Porsiúncula', null),
    (14, 'Mandantes', null),
    (15, 'Manaíra', 1500);