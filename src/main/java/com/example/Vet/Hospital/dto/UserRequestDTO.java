package com.example.Vet.Hospital.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    @Size(min = 2, max = 25, message = "Имя должно быть не менее 2 символов и не более 25 символов!")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Имя должно начинатся с Заглавной буквы")
    private String firstName;
    @Size(min = 2, max = 25, message = "Фамилия должно быть не менее 2 символов и не более 25 символов!")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Фамилия должна начинатся с Заглавной буквы")
    private String secondName;
    @Size(min = 5, max = 10, message = "Логин должен не быть не менее 5 символов и не более 10 символов!")
    private String login;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,20}", message = "Пароль должен быть от 6 символов с использованием цифр, спец. символов, латиницы, наличием строчных и прописных символов")
    private String password;
}
