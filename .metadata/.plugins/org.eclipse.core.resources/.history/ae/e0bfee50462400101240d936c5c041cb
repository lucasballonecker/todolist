package br.com.lucasballonecker.desafio_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lucasballonecker.desafio_todolist.entity.Todo;
import br.com.lucasballonecker.desafio_todolist.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todorepository;

	public TodoService(TodoRepository todorepository) {
		this.todorepository = todorepository;
	}

	public List<Todo> create(Todo todo) {
		todorepository.save(todo);
		return list();
	}

	public List<Todo> list() {
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todorepository.findAll(sort);
	}

	public List<Todo> update(Todo todo) {
		todorepository.save(todo);
		return list();
	}

	public List<Todo> delete(Long id) {
		todorepository.deleteById(id);
		return list(); 
	}
}
