package br.com.lucasballonecker.desafio_todolist.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lucasballonecker.desafio_todolist.dto.DtoRegister;
import br.com.lucasballonecker.desafio_todolist.entity.User;
import br.com.lucasballonecker.desafio_todolist.repository.UserRepository;

@Service
public class RegisterService {
	
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(DtoRegister request) {
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Nome de usuário já existe.");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        
        userRepository.save(user);
    }
}

