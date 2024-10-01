# CRUD de Produtos - Java & Spring Boot

Este projeto consiste em uma aplicação CRUD (Create, Read, Update, Delete) para a gestão de produtos utilizando Java, Spring Boot e Postgres como banco de dados. O projeto também utiliza Swagger para documentar a API e Flyway Migrations para o versionamento do banco de dados.

## Funcionalidades

A aplicação oferece as seguintes operações para a tabela `products`:
- **Criar Produto**: Adicionar um novo produto com nome, preço e quantidade.
- **Listar Produtos**: Exibir todos os produtos cadastrados.
- **Atualizar Produto**: Atualizar as informações de um produto existente.
- **Deletar Produto**: Remover um produto do banco de dados.

## Tecnologias Utilizadas

- **Java 22**
- **Spring Boot 3.3.3**
- **PostgreSQL 14**
- **Swagger** para documentação da API
- **Flyway Migrations** para versionamento do banco de dados
- **Maven** para gerenciamento de dependências

## Pré-requisitos

Antes de rodar a aplicação, você precisará ter instalado:
- Java 22+
- Postgres
- Maven

## Configuração do Banco de Dados

1. Crie um banco de dados Postgres chamado `products`:

   ```sql
   CREATE DATABASE products;

2. Configure as credenciais do banco no arquivo application.properties: <br>
spring.datasource.url=jdbc:postgresql://localhost:5432/products
spring.datasource.username=seu_usuario <br>
spring.datasource.password=sua_senha <br>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect <br>
spring.jpa.hibernate.ddl-auto=update

## Executando a Aplicação

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu_usuario/seu_projeto.git
   cd seu_projeto
   mvn spring-boot:run
- A aplicação estará disponível em http://localhost:8080.

## Documentação da API
  A documentação da API gerada pelo Swagger estará disponível em http://localhost:8080/swagger-ui.html, onde você poderá visualizar e testar os endpoints.

## Endpoints da API
- GET /products: Retorna todos os produtos.
- POST /products: Cria um novo produto.
- PUT /products: Atualiza um produto existente passando o corpo da requisição.
- GET /products/{id}: Retorna o produto pelo ID.
- DELETE /produtos/{id}: Remove um produto.
