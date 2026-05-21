# 🚚 API Shipping ERP

Projeto backend em **Java 17 + Spring Boot** para simulação de cálculo e registro de fretes entre CEPs, com integração a serviços externos de endereço e distância.

> Objetivo do projeto: demonstrar boas práticas de construção de API REST, integração entre serviços e persistência com JPA/PostgreSQL.

---

## ✨ Destaques técnicos

- **Arquitetura em camadas** (`controller`, `service`, `client`, `repository`, `models`, `dtos`, `converter`)
- **Integração externa** para:
  - consulta de endereço por CEP
  - cálculo de distância geográfica
- **Persistência com Spring Data JPA** em PostgreSQL
- **Documentação OpenAPI/Swagger** via `springdoc-openapi`
- **Validação e transformação de dados** com DTOs e conversores

---

## 🧱 Stack

- Java 17
- Spring Boot 3
- Spring Web / WebFlux
- Spring Data JPA
- PostgreSQL
- Maven
- OpenAPI (Swagger UI)

---

## 🗺️ Fluxo da aplicação

1. Cliente chama `GET /shipping` informando `cepOrigin` e `cepDestination`.
2. A API busca os dados de ambos os CEPs no client de endereço.
3. A API calcula a distância entre origem e destino via client de distância.
4. O resultado é convertido, persistido no banco e devolvido ao cliente.

---

## 🔌 Endpoint principal

### `GET /shipping`

**Query params:**
- `cepOrigin` (string)
- `cepDestination` (string)

**Exemplo:**

```bash
curl "http://localhost:8081/shipping?cepOrigin=01001000&cepDestination=20040002"
```

---

## ▶️ Como executar localmente

### Pré-requisitos

- Java 17+
- Maven 3.9+
- PostgreSQL rodando localmente
- Serviço de distância disponível em `http://localhost:8082/v1/distance`

### 1) Configurar banco

No arquivo `shipping_erp/src/main/resources/application.properties` já existe a configuração padrão local:

- database: `shipping_erp`
- user: `postgres`
- password: `root`
- porta da API: `8081`

### 2) Rodar aplicação

```bash
cd shipping_erp
./mvnw spring-boot:run
```

### 3) Acessar documentação

Com a aplicação no ar:

- Swagger UI: `http://localhost:8081/swagger-ui/index.html`

---

## 🧪 Qualidade e próximos passos

### Melhorias planejadas

- [ ] Adicionar testes unitários e de integração
- [ ] Cobrir cenários de erro de APIs externas
- [ ] Incluir autenticação/autorização
- [ ] Containerização com Docker Compose (API + DB + dependências)
- [ ] Pipeline CI (build, test, lint)

---

## 👨‍💻 Valor para recrutadores

Esse repositório demonstra capacidade de:

- estruturar um backend real em Spring Boot
- modelar fluxo de negócio com integração externa
- aplicar separação de responsabilidades
- pensar em evolutividade (testes, CI/CD, observabilidade)

Se quiser, posso também transformar esse projeto em uma versão **"portfolio-ready"** com:

- badges de build/qualidade
- diagrama de arquitetura
- testes automatizados
- Docker para execução com 1 comando
- histórias de decisões técnicas (ADR)
