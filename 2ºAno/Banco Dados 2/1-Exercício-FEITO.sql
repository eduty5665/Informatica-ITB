USE SUPERMERCADO_2B
-- SELECT
--USE SUPERMERCADO_1

/*1) Listar todos os campos da tabela Produto.*/
		SELECT * FROM PRODUTO
		GO

--2) Listar o nome do produto, o código do Fornecedor e o valor unitario da tabela de produtos.
		SELECT NOME_PROD, COD_FORN, VALOR_UNIT FROM PRODUTO
		GO

--3) Listar todos os campos da tabela Fornecedor quando o código do fornecedor for 1001
		SELECT * FROM PRODUTO WHERE COD_FORN LIKE '%1001%'
		GO

--4) Listar os campos NOME_FORN e ENDERECO da tabela Fornecedor quando o código do fornecedor for 4001, 4002 ou 4003)
		SELECT NOME_FORN, COD_FORN, ENDERECO FROM FORNECEDOR WHERE COD_FORN IN (4001, 4002, 4003)
		GO

--5) Listar todos os campos da tabela EMBALAGEM
		SELECT * FROM EMBALAGEM
		GO

--6) Listar o CPF, nome e o endereço dos clientes da tabela CLIENTES quando o SEXO for Masculino.
		SELECT CPF_CLI, NOME_CLI, ENDER_CLI FROM CLIENTE
		GO

--7) Listar o nome, endereço e telefone dos clientes da tabela CLIENTES quando o e-mail for do HOTMAIL.
		SELECT CPF_CLI, NOME_CLI, ENDER_CLI, EMAIL_CLI FROM CLIENTE
		WHERE EMAIL_CLI LIKE '%HOTMAIL%'
		GO

--8) Listar Toda a tabela de PEDIDOS
		SELECT * FROM PEDIDO
		GO

--9) Listar o código do pedido da tabela PEDIDOS quando o código do produto for igual a 1.
		SELECT NUM_PED FROM PEDIDO WHERE COD_PROD = '1'
		GO

--10) Listar Toda a tabela de pedidos quando cliente for 2000.
		SELECT * FROM PEDIDO WHERE COD_CLI = '2000'
		GO

--11) Listar todos os dados dos Cliente que possuem sobrenome SOUZA.
		SELECT * FROM CLIENTE WHERE NOME_CLI LIKE '%SOUZA%'
		GO

--12) Listar O nome, endereço e sexo dos Cliente que não possuem e-mail.
		SELECT NOME_CLI, ENDER_CLI, SEXO_CLI FROM CLIENTE WHERE EMAIL_CLI = ''
		GO

--13) Listar todas os dados da tabela produto quando o produto for um Condicionador para cabelo secos.
		SELECT * FROM PRODUTO WHERE NOME_PROD LIKE '%CONDICIONADOR PARA CABELO SECOS%'
		GO

--14) Listar o codigo,nome e valor unitario dos produtos do fornecedor 4001. 
		SELECT COD_PROD, NOME_PROD, VALOR_UNIT, COD_FORN FROM PRODUTO WHERE COD_FORN = '4001'
		GO

--15) Listar o número do pedido, o codigo do cliente, a quantidade comprada e o valor total do pedido da tabela PEDIDO para os
  --    produtos que a quantidade seja maior que 1 e que o valor total seja maior que R$10,00 e o cliente seja o 18000.
		SELECT NUM_PED, COD_CLI, QTD_PROD, VLOR_TOT FROM PEDIDO WHERE QTD_PROD > '1' AND VLOR_TOT > '10' AND COD_CLI = '18000'
		GO

--16) Pesquisar como somar os valores totais dos pedidos
		SELECT COD_CLI, SUM(VLOR_TOT) FROM PEDIDO
		GROUP BY COD_CLI
		GO
		--FÓRMULA SUM, MIN, MAX
