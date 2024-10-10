USE master IF EXISTS
(select * from sys.databases where name='miniprojeto3b') 
DROP DATABASE miniprojeto3b
GO 
-- CRIAR UM BANCO DE DADOS
CREATE DATABASE miniprojeto3b
GO
-- ACESSAR O BANCO DE DADOS
USE miniprojeto3b
GO

CREATE TABLE Produto
(
	id			 bigINT IDENTITY,
	nome	     VARCHAR(100) NOT NULL,
	descricao	 VARCHAR(400) NOT NULL,
	codigoBarras VARCHAR(100) NOT NULL,
	foto		 varbinary(max) NULL,
	preco		 DECIMAL(8,2) NOT NULL,
	categoria	 VARCHAR(100) NULL,
	destaque	 VARCHAR(100) NULL,
	statusProd	 VARCHAR(10)  NOT NULL, -- ATIVO ou INATIVO
	PRIMARY KEY (id),
)
GO
INSERT Produto (nome, descricao, codigoBarras, foto, 
preco, categoria, destaque, statusProd) 
VALUES ('Garrafa de Água Mineral de 510ml - Boa-água ', 
	'Garrafa de água mineral de 510ml', '7899001234', 
		NULL, 2.00, 'Bebida', 'promoção', 'ATIVO')

GO
SELECT * FROM Produto

