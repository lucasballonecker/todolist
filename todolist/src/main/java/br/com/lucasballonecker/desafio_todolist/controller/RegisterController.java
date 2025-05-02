package br.com.lucasballonecker.desafio_todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasballonecker.desafio_todolist.dto.DtoRegister;
import br.com.lucasballonecker.desafio_todolist.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	    private final RegisterService registerService;

	    public RegisterController(RegisterService registerService) {
	        this.registerService = registerService;
	    }

	    @PostMapping()
	    public ResponseEntity<String> register(@RequestBody DtoRegister request) {
	        registerService.register(request);
	        return ResponseEntity.ok("Usuário registrado com sucesso!");
	    }
	}


