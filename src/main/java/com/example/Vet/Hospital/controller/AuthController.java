package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.Service.CustomUserDetailService;
import com.example.Vet.Hospital.Service.JwtService;
import com.example.Vet.Hospital.dto.JwtRequestDTO;
import com.example.Vet.Hospital.dto.JwtResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService customUserDetailService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> authentication(@RequestBody JwtRequestDTO jwtRequestDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDTO.getUsername(), jwtRequestDTO.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            return new ResponseEntity<>(badCredentialsException.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequestDTO.getUsername());
        String token = jwtService.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}
