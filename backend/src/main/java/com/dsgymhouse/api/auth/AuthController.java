package com.dsgymhouse.api.auth;

import com.dsgymhouse.api.auth.dto.AuthRequest;
import com.dsgymhouse.api.auth.dto.AuthResponse;
import com.dsgymhouse.api.auth.dto.RegisterRequest;
import com.dsgymhouse.api.security.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(Map.of("error", "username_taken"));
        }

        User user = new User(request.getUsername(), passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(Map.of("username", user.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return userRepository.findByUsername(request.getUsername())
                .map(u -> {
                    if (passwordEncoder.matches(request.getPassword(), u.getPassword())) {
                        String token = jwtUtils.generateToken(u.getUsername());
                        return ResponseEntity.ok(new AuthResponse(token));
                    } else {
                        return ResponseEntity.status(401).body(Map.of("error", "invalid_credentials"));
                    }
                })
                .orElseGet(() -> ResponseEntity.status(401).body(Map.of("error", "invalid_credentials")));
    }
}
