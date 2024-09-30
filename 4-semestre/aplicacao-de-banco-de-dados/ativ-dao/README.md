# Atividade de Aplicação de Banco de Dados

Foi criado inicialmente um banco de dados com H2 Database, possuindo as tabelas ALUNO, EMPRESTIMO e PUBLICACAO, referentes ao sistema de biblioteca. Foram adicionadas algumas modificações nas tabelas, adicionando as relações entre tabelas com as “foreign keys”.
O mapeamento foi feito apartir da conexão com o driver do H2 Database, passando o caminho local do banco de dados, e o código das classes foi gerado automaticamente com o gerador de entidades de persistência do NetBeans.
Ademais, esse gerador faz o mapeamento das tabelas selecionadas e faz a relação com os atributos da classe-entidade a ser usada em Java.

# Classe DAO

A classe padrão DAO será responsável por atribuir esta arquitetura à qualquer classe-entidade do sistema. Essa classe irá gerenciar a entidade, por meio das classes de “javax.persistence”, além disso cria os métodos de CRUD (findAll, insert, update e delete) para a manipulação do banco de dados.

# Empréstimo DAO

A classe empréstimo recebe o padrão DAO, que sobrescreve os métodos de CRUD criados na classe DAO padrão, utiliza Criteria para retornar os dados presentes no banco, e a classe de Transaction para operar sobre os métodos de insert, update e delete.

# Ativ DAO

É a classe principal do projeto, responsável pela execução dos testes da classe Empréstimo DAO.
ERRO: O compilador não está conseguindo encontrar a classe main, o que está impedindo a execução dos testes.

## Discentes:
Emily Almeida Abreu  
Luan Henrique dos Santos Silva
