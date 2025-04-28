package br.com.lucasballonecker.desafio_todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.lucasballonecker.desafio_todolist.dto.Dto;
import br.com.lucasballonecker.desafio_todolist.entity.Todo;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void testCreateTodoSuccess() {
		var dto = new Dto("Todo 1", "Desc Todo 1 Up", true, 7);
		
		webTestClient.post().uri("/todos")
		.bodyValue(dto).exchange().expectStatus().isOk()
		.expectBody().jsonPath("$").isArray()
		.jsonPath("$[0].length()").isEqualTo(5)
		.jsonPath("$[0].nome").isEqualTo(dto.nome())
		.jsonPath("$[0].descricao").isEqualTo(dto.descricao())
		.jsonPath("$[0].realizado").isEqualTo(dto.realizado())
		.jsonPath("$[0].prioridade").isEqualTo(dto.prioridade());
	}
	
	@Test
	void testCreateTodoFailure() {
		webTestClient.post().uri("/todos")
		.bodyValue(new Dto("", "", false, 0)).exchange().expectStatus().isBadRequest();
		
	}

}
