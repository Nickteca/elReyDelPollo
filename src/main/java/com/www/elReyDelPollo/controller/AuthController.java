package com.www.elReyDelPollo.controller;

import com.www.elReyDelPollo.component.JwtUtil;
import com.www.elReyDelPollo.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    @Value("${security.password}")
    private String contraseña;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        if (user.getNombreUsuario().equals("admin") && user.getPasswordUsuario().equals(contraseña)) {
            String token = jwtUtil.generarToken(user.getNombreUsuario());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}
