#Criação do Banco de Dados dbHospital
CREATE DATABASE dbHospital;

#Utilização do Banco de Dados dbHospital
USE dbHospital;

#Criação da tabela pacientes
CREATE TABLE pacientes(
	Prontuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	Nome VARCHAR(200),
	CPF VARCHAR(11) NOT NULL,
	Sexo ENUM("M", "F"),
	Telefone VARCHAR(10),
	dataNasc DATE,
	Endereco VARCHAR(200),
	UF CHAR(2)
);

#Criação da tabela medicos
CREATE TABLE medicos(
	CRM INT(6) PRIMARY KEY,
	Nome VARCHAR(200),
	Sexo ENUM("M","F"),
	Senha VARCHAR(255),
	Especialidade VARCHAR(100),
	Telefone VARCHAR(10),
	dataNasc DATE,
	UF CHAR(2),
	idPasc INT,
	FOREIGN KEY (idPasc) REFERENCES pacientes(Prontuario)
);

#Criação da tabela enfermeiros
	CREATE TABLE enfermeiros(
	COREN INT(6) PRIMARY KEY,
	Nome VARCHAR(200),
	Sexo ENUM("M","F"),
	Senha VARCHAR(255),
	Especialidade VARCHAR(100),
	Telefone VARCHAR(10),
	dataNasc DATE,
	UF CHAR(2),
	idPasc INT,
        FOREIGN KEY (idPasc) REFERENCES pacientes(Prontuario)
);

ALTER TABLE pacientes MODIFY CPF VARCHAR(15);

SELECT * FROM pacientes;
SELECT * FROM medicos;
SELECT * FROM enfermeiros;
