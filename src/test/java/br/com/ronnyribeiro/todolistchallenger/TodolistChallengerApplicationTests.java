package br.com.ronnyribeiro.todolistchallenger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.ronnyribeiro.todolistchallenger.entity.Todo;

@SpringBootTest
class TodolistChallengerApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo 1", "desc todo 1",false,1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].name").isEqualTo(todo.getName())
			.jsonPath("$[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$[0].done").isEqualTo(todo.getDone())
			.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}
	
	void testCreateTodoFailure() {
	}
}
