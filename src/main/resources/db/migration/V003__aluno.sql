create table aluno(
id bigint not null primary key auto_increment,
nomealuno varchar(100),
idcurso int not null,
idcidade int not null
);

alter table aluno add constraint
fk_aluno_curso foreign key(idcurso)
references curso(id);

alter table aluno add constraint
FK_aluno_cidade foreign key(idcidade)
references cidade(id);

insert into aluno(nomealuno, idcurso, idcidade) values ('Edriano Campana', 2, 3);
insert into aluno(nomealuno, idcurso, idcidade) values ('Fernando Pessoa', 1, 2);
insert into aluno(nomealuno, idcurso, idcidade) values ('Vivi do sapatinho', 3, 1);
