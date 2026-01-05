Este é um projeto de estudo desenvolvido em **Java 17** com **Spring Boot**. A aplicação simula o gerenciamento de uma frota de veículos, permitindo o cadastro, listagem, aluguel e devolução de carros.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** (Persistência de dados)
- **H2 Database** (Banco de dados em memória para testes)
- **Postman** (Testes de API)

## 🏗️ Arquitetura do Projeto
O projeto segue o padrão de camadas para garantir a separação de responsabilidades:
- **Controller**: Exposição dos endpoints REST.
- **Service**: Concentração das regras de negócio (ex: validação de disponibilidade).
- **Repository**: Interface de comunicação com o banco de dados.
- **DTO (Data Transfer Object)**: Utilização de Records para entrada e saída de dados, garantindo a segurança e o desacoplamento da base de dados.

## 🛠️ Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de ter o JDK 17 instalado.
3. Execute o comando `./mvnw spring-boot:run` ou rode pela sua IDE.
4. A API estará disponível em `http://localhost:8080/carros`.

## 📌 Endpoints Principais
- `GET /carros`: Lista todos os carros cadastrados (via DTO).
- `POST /carros`: Cadastra um novo carro (utiliza CarroRequest).
- `PUT /carros/{id}/alugar`: Altera o status do carro para indisponível.
- `PUT /carros/{id}/devolver`: Altera o status do carro para disponível.