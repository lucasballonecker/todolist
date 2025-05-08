package br.com.lucasballonecker.desafio_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import br.com.lucasballonecker.desafio_todolist.dto.Dto;
import br.com.lucasballonecker.desafio_todolist.dto.DtoUpdate;
import br.com.lucasballonecker.desafio_todolist.entity.Todo;
import br.com.lucasballonecker.desafio_todolist.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository todorepository;

	public TodoService(TodoRepository todorepository) {
		this.todorepository = todorepository;
	}

	public List<Todo> create(Dto dto) {
		todorepository.save(new Todo(dto));
		return list();
	}

	public List<Todo> list() {
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todorepository.findAll(sort);
	}

	public List<Todo> update(DtoUpdate dtou) {
		var dto = todorepository.getReferenceById(dtou.id());
		dto.atualizarInformacoes(dtou);
		return list();
	}

	public List<Todo> delete(Long id) {
		todorepository.deleteById(id);
		return list(); 
	}
}
