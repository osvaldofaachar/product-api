
# API de Gestão de Produtos (Simples)

## Descrição

Esta API foi desenvolvida para gerenciar informações de produtos em uma plataforma de e-commerce. O sistema permite a criação, leitura, atualização e exclusão de produtos, associados a categorias e fornecedores. A API segue a arquitetura RESTful, utilizando o padrão HTTP com os métodos GET, POST, PUT e DELETE para interagir com os recursos.

### Funcionalidades principais:
- **Cadastro de Produtos**: Permite registrar novos produtos com suas respectivas categorias e fornecedores.
- **Consulta de Produtos**: Permite buscar produtos por diversos parâmetros como nome, categoria e fornecedor.
- **Atualização de Produtos**: Permite atualizar as informações de um produto, incluindo sua categoria e fornecedor.
- **Remoção de Produtos**: Permite excluir produtos cadastrados.
- **Validação de Categoria e Fornecedor**: A API garante que cada produto seja vinculado a uma categoria e fornecedor existentes no banco de dados, realizando verificações ao tentar salvar ou atualizar os dados.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Framework para construir a API RESTful)
- **Spring Data JPA** (Para interação com o banco de dados)
- **MySQL** (Banco de dados para persistencia de Dados)
- **Maven** (Gerenciador de dependências e construção do projeto)
- **Insomnia** (Para testes dos Endpoints da API)

## Estrutura do Projeto

A arquitetura do projeto segue um modelo MVC (Model-View-Controller), onde a lógica de negócios, persistência de dados e a interface com o cliente (via API REST) estão bem separadas.

### Pacotes principais:
- **com.osvaldo.product_api.controller**: Contém as classes responsáveis por expor os endpoints da API.
- **com.osvaldo.product_api.service**: Contém a lógica de negócios da aplicação.
- **com.osvaldo.product_api.model**: Contém as classes de modelo (entidades) que representam os dados.
- **com.osvaldo.product_api.repository**: Contém as interfaces para interação com o banco de dados (usando Spring Data JPA).
- **com.osvaldo.product_api.dto**: Contém os Data Transfer Objects (DTOs) usados para a comunicação entre o cliente e a API.

### Classes principais:

#### 1. **ProdutoController**
- Responsável por definir os endpoints da API relacionados aos produtos. 
- Possui métodos para:
  - `POST /api/produtos/` - Criação de novos produtos.
  - `GET /api/produtos/{id}` - Consultar um produto pelo seu ID.
  - `PUT /api/produtos/{id}` - Atualizar um produto.
  - `DELETE /api/produtos/{id}` - Remover um produto.

#### 2. **ProdutoService**
- Contém a lógica de negócios para manipulação de produtos.
- Método principal: 
  - `salvar(ProdutoDTO produtoDTO)` - Cria ou atualiza um produto com base nas informações enviadas.
- Realiza a validação das categorias e fornecedores antes de salvar ou atualizar um produto.
  
#### 3. **ProdutoRepository**
- Interface que estende `JpaRepository` do Spring Data JPA.
- Permite a comunicação com o banco de dados, realizando operações de CRUD (Create, Read, Update, Delete) para a entidade Produto.

#### 4. **CategoriaRepository e FornecedorRepository**
- Interfaces que estendem `JpaRepository` para manipulação das entidades `Categoria` e `Fornecedor`.
- Realizam operações de CRUD para essas entidades.

#### 5. **ProdutoDTO**
- **ProdutoDTO (Data Transfer Object)** é um objeto utilizado para transferir dados entre a API e o cliente.
- Ele possui atributos como `id`, `nome`, `preco`, `categoriaId`, e `fornecedorId`, que são utilizados na criação e atualização de um produto.

#### 6. **Categoria e Fornecedor**
- **Categoria**: Representa a categoria de um produto, como "Eletrônicos", "Roupas", etc.
- **Fornecedor**: Representa o fornecedor do produto, podendo ser uma empresa ou uma pessoa.

### Fluxo de Funcionamento:
1. O cliente envia um pedido POST com os dados de um novo produto, incluindo o `categoriaId` e `fornecedorId`.
2. O controlador (`ProdutoController`) chama o serviço (`ProdutoService`) para validar se os IDs fornecidos existem nas respectivas tabelas de categoria e fornecedor.
3. Caso as validações sejam bem-sucedidas, o serviço converte o DTO em uma entidade `Produto` e a persiste no banco de dados.
4. O cliente recebe a confirmação do produto salvo ou atualizado em formato JSON, com todas as informações, incluindo IDs da categoria e fornecedor.

## Endpoints da API

### 1. Criar Produto
- **Método**: POST
- **URL**: `/api/produtos/`
- **Corpo da Requisição**:
  ```json
  {
    "nome": "Produto Exemplo",
    "preco": 100.0,
    "categoriaId": 1,
    "fornecedorId": 2
  }
  ```
- **Resposta**:
  - Código: 201 Created
  - Corpo da Resposta:
  ```json
  {
    "id": 1,
    "nome": "Produto Exemplo",
    "preco": 100.0,
    "categoriaId": 1,
    "fornecedorId": 2
  }
  ```

### 2. Consultar Produto por ID
- **Método**: GET
- **URL**: `/api/produtos/{id}`
- **Resposta**:
  - Código: 200 OK
  - Corpo da Resposta:
  ```json
  {
    "id": 1,
    "nome": "Produto Exemplo",
    "preco": 100.0,
    "categoriaId": 1,
    "fornecedorId": 2
  }
  ```

### 3. Atualizar Produto
- **Método**: PUT
- **URL**: `/api/produtos/{id}`
- **Corpo da Requisição**:
  ```json
  {
    "nome": "Produto Atualizado",
    "preco": 150.0,
    "categoriaId": 1,
    "fornecedorId": 3
  }
  ```

### 4. Deletar Produto
- **Método**: DELETE
- **URL**: `/api/produtos/{id}`

## Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/osvaldofaachar/product-api.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd product-api
   ```
3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

### Banco de Dados
Este projeto utiliza o **MySQL** como banco de dados em memória para fins de desenvolvimento e testes. Não é necessário configurar um banco de dados externo.

## Testes

Os testes unitários são implementados utilizando **JUnit**. Para rodar os testes, execute o seguinte comando:

```bash
mvn test
```

## Contribuições

Se você deseja contribuir para o projeto, sinta-se à vontade para abrir uma **pull request**. Estou sempre aberto a melhorias!

---

*Obrigado Pela Atenção!!!*