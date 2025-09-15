# api-produtos-springboot
- controller: classes que recebem as requisições HTTP
- service: regras de negócio e lógica de aplicação
- repository: interfaces que faze, a persitência de dados (Spring Data JPA)
- model ou domain: classes de domínio ou entidades do banco de dados;
- config: classes de configuração (exemplo: CORS, segurança)
- util: funções utilitáriais

# comandos importantes

### Executar a Aplicação
``bash
./mvnw spring-boot:run
``
### Executar TEstes
``bash
./mvnw test
``
