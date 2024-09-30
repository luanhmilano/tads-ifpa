-- RESETAR

DROP DATABASE mydb;

SELECT Concat('TRUNCATE TABLE ', table_schema, '.', table_name, ';') 
    FROM INFORMATION_SCHEMA.TABLES where table_schema in ('mydb');

DROP PROCEDURE IF EXISTS RelatorioUsuario;
DROP FUNCTION IF EXISTS AdicionarUsuario;
DROP FUNCTION IF EXISTS AdicionarConta;
DROP FUNCTION IF EXISTS AdicionarCategoria;
DROP FUNCTION IF EXISTS AdicionarDespesa;
DROP FUNCTION IF EXISTS AdicionarReceita;
DROP FUNCTION IF EXISTS SaldoPorConta;

SET FOREIGN_KEY_CHECKS = 0; -- Desabilitar verificação de chaves estrangeiras

SELECT CONCAT('DROP TABLE IF EXISTS `', table_name, '`;')
FROM information_schema.tables
WHERE table_schema = 'mydb';

SET FOREIGN_KEY_CHECKS = 1; -- Reabilitar verificação de chaves estrangeiras