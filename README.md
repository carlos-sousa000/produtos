# StockControl - Sistema de Gerenciamento de Produtos

## Sobre o projeto

O StockControl é um sistema web desenvolvido para facilitar o cadastro e o gerenciamento de produtos de lojas. A aplicação permite organizar informações dos produtos, controlar quantidades em estoque e realizar operações de cadastro, edição e exclusão.

## Funcionalidades

- Cadastro de produtos.
- Listagem de produtos cadastrados.
- Edição das informações dos produtos.
- Exclusão de produtos.
- Controle da quantidade disponível em estoque.
- Cadastro de nome, descrição, categoria e preço.
- Identificação de produtos com estoque baixo ou esgotado.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Thymeleaf
- HTML5
- CSS3
- Maven

## Arquitetura do projeto

- **Entity:** representação dos produtos e seus atributos.
- **Repository:** comunicação com o banco de dados.
- **Service:** implementação das regras de negócio.
- **Controller:** gerenciamento das requisições e páginas.
- **Templates:** estrutura das páginas HTML.
- **Static:** arquivos de estilização CSS.

## Banco de dados

Crie o banco de dados no MySQL:

```sql
CREATE DATABASE loja_produtos;
```

Configure o usuário e a senha no arquivo `src/main/resources/application.properties`.

## Como executar

1. Abra o projeto existente no IntelliJ IDEA.
2. Copie a pasta `src` deste projeto para a pasta principal do seu projeto, mesclando os arquivos quando solicitado.
3. Confira se as dependências Spring Web, Spring Data JPA, MySQL Driver, Thymeleaf e Validation estão no seu `pom.xml`.
4. Inicie o MySQL e crie o banco `loja_produtos`.
5. Ajuste o usuário e a senha do banco no `application.properties`.
6. Execute a classe `SistemaprodutosApplication`.
7. Acesse `http://localhost:8080/produtos`.
