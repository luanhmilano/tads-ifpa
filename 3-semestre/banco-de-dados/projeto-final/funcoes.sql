-- FUNÇÕES

-- ADICIONAR USUÁRIO

DELIMITER //

CREATE FUNCTION AdicionarUsuario(
    p_Nome VARCHAR(100),
    p_Email VARCHAR(100)
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE novo_usuario_id INT;

    INSERT INTO Usuario (Nome, Email)
    VALUES (p_Nome, p_Email);

    SET novo_usuario_id = LAST_INSERT_ID();

    RETURN novo_usuario_id;
END //

DELIMITER ;

-- ADICIONAR CONTA

DELIMITER //

CREATE FUNCTION AdicionarConta(
	p_ID_usuario INT,
    p_Nome_da_conta VARCHAR(20),
    p_Saldo DECIMAL(10, 2),
    p_Tipo_de_conta VARCHAR(50)
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE nova_conta_id INT;

    INSERT INTO Conta (ID_usuario, Nome_da_conta, Saldo, Tipo_de_conta)
    VALUES (p_ID_usuario, p_Nome_da_conta, p_Saldo, p_Tipo_de_conta);

    SET nova_conta_id = LAST_INSERT_ID();

    RETURN nova_conta_id;
END //

DELIMITER ;

-- ADICIONAR CATEGORIA

DELIMITER //

CREATE FUNCTION AdicionarCategoria(
    p_Tipo VARCHAR(20)
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE nova_categoria_id INT;

    INSERT INTO Categoria (Tipo)
    VALUES (p_Tipo);

    SET nova_categoria_id = LAST_INSERT_ID();

    RETURN nova_categoria_id;
END //

DELIMITER ;

-- ADICIONAR RECEITA

DELIMITER //

CREATE FUNCTION AdicionarReceita(
    p_ID_Conta INT,
    p_Nome_Receita VARCHAR(50),
    p_Valor DECIMAL(10, 2),
    p_Detalhes VARCHAR(100),
    p_ID_Categoria INT
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE nova_receita_id INT;
    
    -- Inserir nova receita
    INSERT INTO Receitas (Nome, Detalhes)
    VALUES (p_Nome_Receita, p_Detalhes);
    
    -- Capturar o ID da nova receita inserida
    SET nova_receita_id = LAST_INSERT_ID();
    
    -- Inserir transação associada à conta para a nova receita
    INSERT INTO Transacao (ID_Conta, Valor, Data, Tipo, ID_Categoria, ID_Receita)
    VALUES (p_ID_Conta, p_Valor, now(), 'Receita', p_ID_Categoria, nova_receita_id);
    
    RETURN nova_receita_id;
END //

DELIMITER ;

-- ADICIONAR DESPESA

DELIMITER //

CREATE FUNCTION AdicionarDespesa(
    p_ID_Conta INT,
    p_Nome_Despesa VARCHAR(50),
    p_Valor DECIMAL(10, 2),
    p_Detalhes VARCHAR(100),
    p_ID_Categoria INT
)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE nova_despesa_id INT;
    
    -- Inserir nova receita
    INSERT INTO Despesas (Nome, Detalhes)
    VALUES (p_Nome_Despesa, p_Detalhes);
    
    -- Capturar o ID da nova receita inserida
    SET nova_despesa_id = LAST_INSERT_ID();
    
    -- Inserir transação associada à conta para a nova receita
    INSERT INTO Transacao (ID_Conta, Valor, Data, Tipo, ID_Categoria, ID_Despesa)
    VALUES (p_ID_Conta, p_Valor, now(), 'Despesa', p_ID_Categoria, nova_despesa_id);
    
    RETURN nova_despesa_id;
END //

DELIMITER ;

-- SALDO DE CONTA

DELIMITER //

CREATE FUNCTION SaldoPorConta(
    p_ID_Conta INT
)
RETURNS DECIMAL(10, 2)
READS SQL DATA
BEGIN
    DECLARE saldo DECIMAL(10, 2);

    SELECT COALESCE(SUM(CASE WHEN t.Tipo = 'Receita' THEN t.Valor ELSE -t.Valor END), 0) INTO saldo
    FROM Transacao t
    WHERE t.ID_Conta = p_ID_Conta;

    RETURN saldo;
END //

DELIMITER ;

-- TRANSACOES POR CONTA

DELIMITER //

CREATE PROCEDURE TransacoesConta(
    p_ID_Conta INT
)
BEGIN
    SELECT *
    FROM Transacao
    WHERE ID_Conta = p_ID_Conta;
END //

DELIMITER ;

-- TRANSAÇÕES POR CATEGORIA GERAL

DELIMITER //

CREATE PROCEDURE RelatorioTransacoesPorCategoria()
BEGIN
    SELECT Categoria.Tipo AS Nome_Categoria,
           Transacao.Tipo AS Tipo_Transacao,
           SUM(Transacao.Valor) AS Total
    FROM Transacao
    INNER JOIN Categoria ON Transacao.ID_Categoria = Categoria.ID
    GROUP BY Categoria.Tipo, Transacao.Tipo;
END //

DELIMITER ;

-- TRANSAÇÕES POR CATEGORIA DE USUÁRIO

DELIMITER //

CREATE PROCEDURE RelatorioUsuario(
    p_ID_Usuario INT
)
BEGIN
    SELECT c.Tipo AS Nome_Categoria,
           t.Tipo AS Tipo_Transacao,
           SUM(t.Valor) AS Total,
           CASE 
               WHEN t.Tipo = 'Receita' THEN r.Nome
               WHEN t.Tipo = 'Despesa' THEN d.Nome
               ELSE '' 
           END AS Nome_Transacao,
           CASE 
               WHEN t.Tipo = 'Receita' THEN r.Detalhes
               WHEN t.Tipo = 'Despesa' THEN d.Detalhes
               ELSE ''
           END AS Detalhes_Transacao
    FROM Transacao t
    INNER JOIN Categoria c ON t.ID_Categoria = c.ID
    INNER JOIN Conta co ON t.ID_Conta = co.ID
    LEFT JOIN Receitas r ON t.ID_Receita = r.ID
    LEFT JOIN Despesas d ON t.ID_Despesa = d.ID
    WHERE co.ID_Usuario = p_ID_Usuario
    GROUP BY c.Tipo, t.Tipo, Nome_Transacao, Detalhes_Transacao;
END //

DELIMITER ;

-- RESETAR BANCO DE DADOS

DELIMITER //

CREATE PROCEDURE Resetar()
BEGIN
	DROP DATABASE mydb;
END //

DELIMITER ;