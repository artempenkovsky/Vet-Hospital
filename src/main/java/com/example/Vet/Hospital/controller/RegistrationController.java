package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.Service.impl.UserServiceImpl;
import com.example.Vet.Hospital.dto.UserDTO;
import com.example.Vet.Hospital.dto.UserRequestDTO;
import com.example.Vet.Hospital.validation.UserRequestDTOValidation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserServiceImpl userService;
    private final UserRequestDTOValidation userRequestDTOValidation;
    @PostMapping
    public ResponseEntity<?> registration(@RequestBody @Valid UserRequestDTO user, BindingResult bindingResult) {
        userRequestDTOValidation.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            List<String> getDefaultErrorMessage = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
            return new ResponseEntity<>(getDefaultErrorMessage, HttpStatus.BAD_REQUEST);
        }
        UserDTO saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.OK);
    }
}
