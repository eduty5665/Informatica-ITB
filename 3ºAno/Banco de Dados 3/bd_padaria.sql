USE MASTER IF EXISTS(SELECT * FROM SYS.databases WHERE NAME = 'bd_padaria')
DROP DATABASE bd_padaria
GO

CREATE DATABASE bd_padaria
GO

USE bd_padaria
GO

CREATE TABLE Usuario
( 
   id            INT IDENTITY,
   nome          VARCHAR(100)	NOT NULL,
   email         VARCHAR(100)	NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(10)    NULL, -- ADM, TEC ou USER
   foto			 VARBINARY(MAX) NULL,
   statusUsuario VARCHAR(20)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA

   PRIMARY KEY (id)
)

select * from Usuario
