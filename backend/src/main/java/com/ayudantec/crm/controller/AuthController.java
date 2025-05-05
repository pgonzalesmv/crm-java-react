package com.ayudantec.crm.controller;

import com.ayudantec.crm.dto.LoginRequest;
import com.ayudantec.crm.dto.RegisterRequest;
import com.ayudantec.crm.dto.UserResponse;
import com.ayudantec.crm.model.User;
import com.ayudantec.crm.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setNombre(registerRequest.getNombre());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setRol(registerRequest.getRol());
        
        User registeredUser = authService.registerUser(user);
        
        UserResponse response = new UserResponse();
        response.setId(registeredUser.getId());
        response.setNombre(registeredUser.getNombre());
        response.setEmail(registeredUser.getEmail());
        response.setRol(registeredUser.getRol());
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = authService.authenticateUser(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setNombre(user.getNombre());
            response.setEmail(user.getEmail());
            response.setRol(user.getRol());
            
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}