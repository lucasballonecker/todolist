package br.com.lucasballonecker.desafio_todolist.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasballonecker.desafio_todolist.dto.Dto;
import br.com.lucasballonecker.desafio_todolist.dto.DtoUpdate;
import br.com.lucasballonecker.desafio_todolist.entity.Todo;
import br.com.lucasballonecker.desafio_todolist.service.TodoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
@SecurityRequirement(name = "Bearer Authentication")
public class TodoController {
	private TodoService todoservice;

	public TodoController(TodoService todoservice) {
		this.todoservice = todoservice;
	}
	
	@PostMapping
	List<Todo> create(@RequestBody @Valid Dto dto) {
		return todoservice.create(dto);
	}

	@GetMapping
	List<Todo> list() {
		return todoservice.list();
	}

	@PutMapping()
	List<Todo> update(@RequestBody  DtoUpdate dtou) {
		return todoservice.update(dtou);
	}

	@DeleteMapping("{id}")
	List<Todo> delete( @PathVariable("id") Long id) {
		return todoservice.delete(id);
	}
}
