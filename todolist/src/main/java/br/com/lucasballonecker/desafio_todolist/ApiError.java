package br.com.lucasballonecker.desafio_todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ApiError {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratador404(EntityNotFoundException e){
		
		return ResponseEntity.notFound().build();
		
	  }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> tratador400(MethodArgumentNotValidException e){
		
		var erros = e.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
	}
	
	public record DadosErros(String mensagem, String campo) {
		public DadosErros(FieldError erro) {
			
			this(erro.getDefaultMessage(), erro.getField());
			
		}
	}
	
}
