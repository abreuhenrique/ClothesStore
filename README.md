# 👕 ClothesStore

**ClothesStore** é uma API REST desenvolvida em Java com Spring Boot, com foco no backend de uma aplicação para uma loja de roupas.

O projeto foi desenvolvido com o objetivo de aplicar conceitos de desenvolvimento de APIs, integração com banco de dados relacional, persistência de informações e documentação de serviços REST.

Essa API foi criada inicialmente para ser consumida pelo frontend de um site de venda de roupas.

## 🚀 Tecnologias utilizadas

O projeto utiliza as seguintes tecnologias:

- **Java 17** – Linguagem de programação.
- **Spring Boot 4.1.2** – Framework para desenvolvimento da aplicação.
- **Spring Web MVC** – Desenvolvimento de endpoints REST.
- **Spring Data JPA** – Persistência e gerenciamento de dados.
- **MySQL** – Banco de dados relacional.
- **Flyway** – Gerenciamento e versionamento de migrações do banco de dados.
- **SpringDoc OpenAPI** – Documentação e visualização dos endpoints da API.
- **Lombok** – Redução de código repetitivo.
- **Maven** – Gerenciamento de dependências e build do projeto.

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

- Java JDK 17 ou superior compatível.
- MySQL.
- Git.

O projeto também disponibiliza o Maven Wrapper para facilitar sua execução.

## 📥 Como executar o projeto

**1. Clone o repositório**

```bash
git clone https://github.com/abreuhenrique/ClothesStore.git
```

**2. Acesse a pasta do projeto**

```bash
cd ClothesStore
```

**3. Configure o banco de dados**

Crie um banco de dados no MySQL e configure as informações de conexão nas propriedades da aplicação.

Utilize as mesmas configurações esperadas pelo projeto para usuário, senha e URL de conexão.

**4. Execute a aplicação**

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

Após a inicialização, a aplicação estará disponível para receber requisições HTTP.

## 🧪 Executando os testes

Para executar os testes automatizados:

Linux ou macOS:

```bash
./mvnw test
```

Windows:

```bash
mvnw.cmd test
```

## Exemplos de requisições


### Criar um produto

**Endpoint:** `POST /product`

**Request Body:**

```json
{
  "name": "Vestido azul marinho",       
  "description": "Vestido longo com acabamento elegante.",
  "price": 349.90,
  "imgUrl": "imagens/produto/vestido-9.jpg",
  "category": "VESTIDOS",
  "availableSizes": ["P", "M", "G"]
}
```

### Listar todos os produtos:

**Endpoint:** `GET /product`

### Listar produto por ID:

**Endpoint:** `GET /product/{id}`

#### Atualizar produto:
**Endpoint:** `PUT /product/{id}`

**Request Body:**
```json
{
  "name": "Vestido branco atualizado",
  "description": "Vestido longo branco para ocasiões especiais.",
  "price": 399.90,
  "imgUrl": "imagens/produto/vestido-branco-novo.jpg",
  "category": "VESTIDOS",
  "availableSizes": ["PP", "P", "M", "G", "GG"]
}
```
### Excluir produto:
**Endpoint:** `DELETE /product/{id}`

### Criar um pedido:
**Endpoint:** `POST /orders`

**Request Body:**
```json
{
  "customerName": "Maria da Silva",
  "customerEmail": "maria@email.com",
  "customerPhone": "85999999999",
  "shippingAddress": {
    "cep": "60000-000",
    "street": "Rua Principal",
    "number": "100",
    "complement": "Apartamento 201",
    "district": "Centro",
    "city": "Fortaleza",
    "state": "CE"
  },
  "items": [
    {
      "productId": 1,
      "selectedSize": "M",
      "quantity": 2
    },
    {
      "productId": 2,
      "selectedSize": "G",
      "quantity": 1
    }
  ]
}
```

### Listar todos os pedidos

**Endpoint:** `GET /orders`

### Listar pedido por número

**Endpoint:** `GET /orders/{orderNumber}`

### Atualizar status do pedido

**Endpoint:** `PATCH /orders/{id}/status`

**Request Body:**
```json
{
  "orderStatus": "CONFIRMED"
}
```

### Status disponíveis:
CREATED
CONFIRMED
PREPARING
SHIPPED
DELIVERED
CANCELLED

### Categorias disponíveis:
VESTIDOS
CONJUNTOS_FEMININOS
CAMISAS_MASCULINAS

### Tamanhos disponíveis:
PP
P
M
G
GG

## 🎯 Objetivos do projeto

Este projeto foi desenvolvido com o propósito de:

- Aplicar conhecimentos de Java e Spring Boot.
- Desenvolver uma API REST para o contexto de uma loja de roupas.
- Trabalhar com persistência de dados utilizando Spring Data JPA.
- Integrar uma aplicação Java com MySQL.
- Gerenciar migrações de banco de dados com Flyway.
- Documentar serviços REST utilizando OpenAPI e Swagger.
- Aprimorar conhecimentos em arquitetura e desenvolvimento backend.

## 👨‍💻 Desenvolvedor

**Henrique Abreu**

Desenvolvedor interessado em tecnologia, desenvolvimento backend e construção de soluções utilizando Java.


⭐ Se este projeto despertou seu interesse, fique à vontade para explorar o código e acompanhar sua evolução!
