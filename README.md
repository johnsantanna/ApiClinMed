# Projeto de Sistema de Médicos

Este é um projeto de demonstração onde estou aplicando conceitos de **Java**, **Spring Boot**, **API REST**, **DTOs**, **Padrões de Projeto**, **Integração com Banco de Dados**, **Git**, e **Paginação**. O objetivo do projeto é criar uma API para gerenciar informações sobre médicos, com funcionalidades de cadastro, consulta e controle de dados.

## Tecnologias Utilizadas

- **Java** (JDK 17+)
- **Spring Boot** (Spring MVC, Spring Data JPA, Spring Validation)
- **Spring Security** (para autenticação e autorização)
- **H2 Database** (para testes, pode ser substituído por outros bancos de dados)
- **Git** (controle de versão)
- **DTOs** (Data Transfer Objects) para facilitar a comunicação entre a API e o frontend
- **JPA/Hibernate** (para interação com o banco de dados)
- **Insomnia** (para testar as requisições da API)

## Funcionalidades Implementadas

1. **Cadastro de Médicos**:
   - Utilizando um DTO específico para o cadastro (`MedicoCadastroDTO`).
   - Validação dos dados com **anotações do Spring Validation** (`@NotBlank`, `@Email`, `@Size`, etc).

2. **Consulta de Médicos**:
   - Implementação de um endpoint `GET` para consultar médicos com um DTO específico para consulta (`MedicoConsultaDTO`), que oculta informações como `id` e `telefone`.
   - Paginação utilizando `Pageable` para controlar a quantidade de resultados retornados por vez.

3. **Exclusão de Médicos**:
   - Endpoint para remoção de médicos do sistema.

4. **Integração com o Banco de Dados**:
   - Utilização do Spring Data JPA para mapear as entidades e realizar operações de CRUD (Create, Read, Update, Delete).
   - Conexão com o banco de dados H2 para testes.

5. **Controle de Versão com Git**:
   - Repositório Git para versionamento de código.
   - Comandos `git add`, `git commit`, e `git push` para gerenciar alterações no código.

## Estrutura do Projeto

- **src/main/java**: Contém as classes do backend, incluindo controladores, serviços e repositórios.
- **src/main/resources**: Contém arquivos de configuração, como `application.properties` para configurações do Spring Boot.
- **src/test/java**: Contém os testes unitários e de integração.

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
