-- UPDATE
SELECT * FROM PRODUTO
SELECT * FROM FORNECEDOR
SELECT * FROM PEDIDO
SELECT * FROM EMBALAGEM
SELECT * FROM CLIENTE

-- USE SUPERMERCADO_2B;
	USE SUPERMERCADO_2B

--1) Na tabela PRODUTO, aumentar o VALOR_UNIT em R$ 1.00 dos produtos que começam com a palavra SHAMPOO.
	UPDATE PRODUTO
	SET VALOR_UNIT = VALOR_UNIT + 1--,
		--NOME_PROD = 'SHAMPOO'
	WHERE NOME_PROD LIKE 'SHAMPOO%'
	--1.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM NOME_PROD, VALOR_UNIT, VALOR_UNIT + 1 FROM PRODUTO 
		WHERE NOME_PROD LIKE 'SHAMPOO%'

--2) Alterar o preço do produto de código 52 para R$ 20.00
	UPDATE PRODUTO
	SET VALOR_UNIT = 20
	WHERE COD_PROD = 52
	--2.1) Fazer um SELECT para ver como ficou o novo valor na tabela
	SELECT * FROM PRODUTO WHERE COD_PROD = 52
--3) Alterar o telefone do Fornecedor 2135 para 1121035835
	UPDATE FORNECEDOR
	SET TELEFONE = 1121035835
	WHERE COD_FORN = 2135

	--3.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM FORNECEDOR WHERE COD_FORN = 2135

--4) Para o Fornecedor 1005, alterar o telefone  para 1155553894
	UPDATE FORNECEDOR
	SET TELEFONE = 1155553894
	WHERE COD_FORN = 1005

	--4.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM FORNECEDOR WHERE COD_FORN = 1005

--5) Dar um desconto de 10% no VLOR_TOT do PEDIDO do cliente 13000
	UPDATE PEDIDO
	SET VLOR_TOT = VLOR_TOT * 0.9
	WHERE COD_CLI = 13000

	--5.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM PEDIDO WHERE COD_CLI = 13000

--6) Alterar o TIPO_EMBAL dos PRODUTOS do Fornecedor 1001 para 2.
	UPDATE PRODUTO
	SET TIPO_EMBAL = 2
	WHERE COD_FORN = 1001

	--6.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM PRODUTO WHERE COD_FORN = 1001

--7) Dar um desconto de 15% no VLOR_TOT do produto 1 na tabela PEDIDO
	UPDATE PEDIDO
	SET VLOR_TOT = VLOR_TOT * 0.85
	WHERE COD_PROD = 1

	--7.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM PEDIDO WHERE COD_PROD = 1

--8) Mudar o endereço do cliente de código 3000 para 'RUA DA PAZ, 1000 - SAO CAETANO DO SUL - SP'
	UPDATE CLIENTE
	SET ENDER_CLI = 'RUA DA PAZ, 1000 - SAO CAETANO DO SUL - SP'
	WHERE COD_CLI = 3000

	--8.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT * FROM CLIENTE WHERE COD_CLI = 3000

--9) Na tabela PEDIDO dar um desconto de 20% no VLOR_TOT nos pedidos pertencentes aos Clientes do Sexo Feminino.
	UPDATE PEDIDO
	SET VLOR_TOT = VLOR_TOT * 0.8
	WHERE COD_CLI IN(SELECT PEDIDO.COD_CLI
	FROM PEDIDO INNER JOIN CLIENTE 
	ON PEDIDO.COD_CLI = CLIENTE.COD_CLI 
	WHERE SEXO_CLI = 'M'
	GROUP BY PEDIDO.COD_CLI)

	--9.1) Fazer um SELECT para ver como ficou o novo valor na tabela
		SELECT PEDIDO.COD_CLI, *
		FROM PEDIDO INNER JOIN CLIENTE 
		ON PEDIDO.COD_CLI = CLIENTE.COD_CLI 
		WHERE SEXO_CLI = 'M'
