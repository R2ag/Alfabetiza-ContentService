# Content Service - Alfabetiza+

Este projeto é o microserviço **Content Service** da aplicação **Alfabetiza+**, responsável por gerenciar o conteúdo educacional, incluindo unidades, aulas, atividades, práticas e opções de resposta.

## Visão Geral

O **Content Service** é desenvolvido utilizando **Spring Boot** e segue a arquitetura de **microserviços**. Ele expõe uma API REST que permite operações CRUD (Criar, Ler, Atualizar, Deletar) em diferentes entidades relacionadas ao conteúdo educacional.

### Entidades Gerenciadas

- **Unit** (Unidade): Representa uma unidade de ensino com uma lista de objetivos e várias aulas.
- **Lesson** (Aula): Cada unidade contém várias aulas, que por sua vez possuem atividades.
- **Activity** (Atividade): Cada aula contém várias atividades que incluem vídeos e práticas.
- **Practice** (Prática): Cada atividade pode conter práticas com perguntas e respostas.
- **AnswerOption** (Opção de Resposta): Cada prática possui várias opções de resposta, sendo apenas uma a correta.

## Requisitos

### Tecnologias Utilizadas

- **Java 21** (ou superior)
- **Spring Boot** (versão 3.3.x)
- **Maven**
- **JPA / Hibernate** (para persistência de dados)
- **H2 Database** (pode ser trocado por outro banco de dados, como MySQL ou PostgreSQL)
- **Lombok** (para reduzir boilerplate de código)
- **Swagger** (para documentação da API)

### Dependências

Confira o arquivo `pom.xml` para uma lista completa das dependências do projeto.

## Configuração do Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/content-service.git
   cd content-service
   ```

2. **Build do projeto:**

   Compile e construa o projeto com o Maven:

   ```bash
   mvn clean install
   ```

3. **Executar o serviço:**

   Após a construção, execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

4. **Acessar a documentação da API (Swagger):**

   Após iniciar o serviço, você pode acessar a documentação da API via Swagger:

   ```
   http://localhost:8080/swagger-ui.html
   ```

## Endpoints

### Unit Controller

- **GET /api/units** - Obter todas as unidades
- **GET /api/units/{id}** - Obter uma unidade por ID
- **POST /api/units** - Criar uma nova unidade
- **PUT /api/units/{id}** - Atualizar uma unidade existente
- **DELETE /api/units/{id}** - Deletar uma unidade

### Lesson Controller

- **GET /api/lessons** - Obter todas as aulas
- **GET /api/lessons/{id}** - Obter uma aula por ID
- **POST /api/lessons** - Criar uma nova aula
- **PUT /api/lessons/{id}** - Atualizar uma aula existente
- **DELETE /api/lessons/{id}** - Deletar uma aula

### Activity Controller

- **GET /api/activities** - Obter todas as atividades
- **GET /api/activities/{id}** - Obter uma atividade por ID
- **POST /api/activities** - Criar uma nova atividade
- **PUT /api/activities/{id}** - Atualizar uma atividade existente
- **DELETE /api/activities/{id}** - Deletar uma atividade

### Practice Controller

- **GET /api/practices** - Obter todas as práticas
- **GET /api/practices/{id}** - Obter uma prática por ID
- **POST /api/practices** - Criar uma nova prática
- **PUT /api/practices/{id}** - Atualizar uma prática existente
- **DELETE /api/practices/{id}** - Deletar uma prática

### AnswerOption Controller

- **GET /api/answer-options** - Obter todas as opções de resposta
- **GET /api/answer-options/{id}** - Obter uma opção de resposta por ID
- **POST /api/answer-options** - Criar uma nova opção de resposta
- **PUT /api/answer-options/{id}** - Atualizar uma opção de resposta existente
- **DELETE /api/answer-options/{id}** - Deletar uma opção de resposta

## Estrutura do Projeto

Abaixo está um breve resumo da estrutura do projeto:

```
content-service/
├── src/
│   ├── main/
│   │   ├── java/com/alfabetiza/contentservice/
│   │   │   ├── controller/  # Controladores REST
│   │   │   ├── model/       # Entidades JPA
│   │   │   ├── repository/  # Repositórios JPA
│   │   │   ├── service/     # Regras de negócio
│   │   └── resources/
│   │       └── application.properties  # Configurações
├── pom.xml
```

## Variáveis de Configuração

O arquivo `application.properties` contém as configurações básicas para o banco de dados e o servidor. Você pode customizá-lo conforme necessário:

```properties
# Porta do servidor
server.port=8080

# Configuração do banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

Para utilizar outro banco de dados (como MySQL ou PostgreSQL), basta atualizar as configurações do `application.properties` com as credenciais do seu banco.

## Testes

Para executar os testes unitários e de integração:

```bash
mvn test
```

## Contribuição

1. Faça um **fork** do projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/nova-feature`)
3. Faça **commit** das suas alterações (`git commit -am 'Adiciona nova feature'`)
4. **Submeta** a branch (`git push origin feature/nova-feature`)
5. Abra um **Pull Request**

---

## Licença

Este projeto é licenciado sob os termos da licença MIT. Para mais detalhes, consulte o arquivo [LICENSE](LICENSE).

---

**Desenvolvido por: Rafael Lacerda**

