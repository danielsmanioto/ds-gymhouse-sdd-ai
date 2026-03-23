package com.dsgymhouse.api.auth;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dsgymhouse.api.auth.dto.AuthRequest;
import com.dsgymhouse.api.auth.dto.RegisterRequest;
import com.dsgymhouse.api.auth.dto.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private com.dsgymhouse.api.security.JwtUtils jwtUtils;

    @Test
    void registerSuccess() throws Exception {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("alice");
        req.setPassword("pass");

        when(userRepository.existsByUsername("alice")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenAnswer(inv -> {
            User u = inv.getArgument(0);
            u.setId(1L);
            return u;
        });

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("alice"));
    }

    @Test
    void registerDuplicate() throws Exception {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("bob");
        req.setPassword("pass");

        when(userRepository.existsByUsername("bob")).thenReturn(true);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("username_taken"));
    }

    @Test
    void loginSuccess() throws Exception {
        AuthRequest req = new AuthRequest();
        req.setUsername("carol");
        req.setPassword("pwd");

        User stored = new User();
        stored.setId(2L);
        stored.setUsername("carol");
        stored.setPassword("encoded");

        when(userRepository.findByUsername("carol")).thenReturn(Optional.of(stored));
        when(passwordEncoder.matches("pwd", "encoded")).thenReturn(true);
        when(jwtUtils.generateToken("carol")).thenReturn("tok-123");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("tok-123"));
    }

    @Test
    void loginInvalidCredentials() throws Exception {
        AuthRequest req = new AuthRequest();
        req.setUsername("dave");
        req.setPassword("wrong");

        User stored = new User();
        stored.setId(3L);
        stored.setUsername("dave");
        stored.setPassword("encoded");

        when(userRepository.findByUsername("dave")).thenReturn(Optional.of(stored));
        when(passwordEncoder.matches("wrong", "encoded")).thenReturn(false);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").value("invalid_credentials"));
    }
}
