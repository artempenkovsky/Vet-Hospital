package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.Service.impl.UserServiceImpl;
import com.example.Vet.Hospital.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<?> registration(User user) {
        userService.createUser(user);
        return null;
    }
}
