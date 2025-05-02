package br.com.lucasballonecker.desafio_todolist.dto;



public record DtoUpdate(
		Long id,
		String nome,
		String descricao,
		Boolean realizado,
		Integer prioridade) {

}
