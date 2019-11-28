use bdaula;

create table paciente(
	cpf varchar(14) primary key,
    nome varchar(50),
    nascimento date,
    sexo char
);

create table consulta(
	id int primary key auto_increment,
	dataConsulta date,
    cpfPaciente varchar(14),

    CONSTRAINT fk_cpfPaciente FOREIGN key(cpfPaciente) REFERENCES bdaula.paciente(cpf)
);

select * from paciente;
select * from consulta;

insert into paciente(cpf,nome,idade,genero) values ('123.123.123-12', 'joaquim', '1988/09/13','M');
insert into paciente(cpf,nome,idade,genero) values ('321.321.321-32', 'joao', '1988/09/14','M');
insert into consulta(dataConsulta, cpfPaciente) values ('2019/11/10', '123.123.123-12');
insert into consulta(dataConsulta, cpfPaciente) values ('2019/11/11', '321.321.321-32');

SELECT * FROM paciente INNER JOIN consulta on paciente.cpf = consulta.cpfPaciente and paciente.nome = 'joaquim';
