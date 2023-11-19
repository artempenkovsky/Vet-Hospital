package com.example.Vet.Hospital.validation;

import com.example.Vet.Hospital.dto.UserRequestDTO;
import com.example.Vet.Hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserRequestDTOValidation implements Validator {
    public final UserRepository  userRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDTO userRequestDTO = (UserRequestDTO) target;
        if (userRepository.findByLogin(userRequestDTO.getLogin()).isPresent()){
            errors.rejectValue("login", "error message", "Такой логин уже присутствует в системе!");
        }
    }
}
