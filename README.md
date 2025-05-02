# todolist

```markdown
# 📝 To-Do List API com Spring Boot & JWT

![Badge](https://img.shields.io/badge/spring--boot-3.4.5-brightgreen)
![Badge](https://img.shields.io/badge/java-24-blue)
![Badge](https://img.shields.io/badge/security-jwt-orange)
![Badge](https://img.shields.io/badge/license-MIT-green)

API RESTful para gerenciamento de tarefas com autenticação JWT, desenvolvida em Spring Boot 3.

## ✨ Funcionalidades
- CRUD completo de tarefas
- Autenticação JWT com Spring Security
- Documentação Swagger/OpenAPI integrada
- Validação de dados com Bean Validation
- Testes automatizados com WebTestClient

## 🛠️ Tecnologias
- Java 24
- Spring Boot 3.4.5
- Spring Security + JWT
- Spring Data JPA
- MySQL/H2 Database
- SpringDoc OpenAPI

## ⚡ Como Executar

### Pré-requisitos
- JDK 24+
- Maven 3.9+
- MySQL ou H2

```bash
git clone https://github.com/lucasballonecker/todolist.git
cd todolist
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## 🔐 Autenticação
```http
POST /register
Content-Type: application/json

{
  "username": "novousuario",
  "password": "senha123"
}

POST /authentication
Content-Type: application/json

{
  "username": "novousuario",
  "password": "senha123"
}
```

## 📋 Endpoints Principais
Todos os endpoints requerem:
```http
Authorization: Bearer <seu_token>
```

| Método | Endpoint   | Descrição          |
|--------|------------|--------------------|
| GET    | /todos     | Listar tarefas     |
| POST   | /todos     | Criar tarefa       |
| PUT    | /todos     | Atualizar tarefa   |
| DELETE | /todos/{id}| Remover tarefa     |

## 📚 Documentação
Acesse a documentação interativa:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI: `http://localhost:8080/v3/api-docs`

## 🧪 Testes
```bash
mvn test
```

## 🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie sua branch (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Add nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📜 Licença
MIT - Veja [LICENSE](LICENSE) para detalhes.

---

**⭐ Se gostou, deixe uma estrela no repositório!**  
**🐛 Problemas? [Abra uma issue](https://github.com/lucasballonecker/todolist/issues)**
```


