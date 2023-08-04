create table cidade(
id int not null primary key auto_increment,
nomecidade varchar(70),
UF char(2)
);

insert into cidade(nomecidade, UF) values ('Bauru', 'SP');
insert into cidade(nomecidade, UF) values ('Juiz de fora', 'MG');
insert into cidade(nomecidade, UF) values ('Barra bonita', 'SP');

