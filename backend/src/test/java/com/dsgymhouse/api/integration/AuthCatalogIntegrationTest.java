package com.dsgymhouse.api.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dsgymhouse.api.auth.UserRepository;
import com.dsgymhouse.api.workout.Workout;
import com.dsgymhouse.api.workout.WorkoutRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = "spring.jpa.hibernate.ddl-auto=create-drop")
@AutoConfigureMockMvc
class AuthCatalogIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @BeforeEach
    void setup() {
        userRepository.deleteAll();
        workoutRepository.deleteAll();

        workoutRepository.save(new Workout(
                "Treino Cardio 20min",
                "cardio",
                Workout.WorkoutLevel.iniciante,
                20,
                Workout.WorkoutFormat.video,
                "Aqueça 5 minutos e siga o vídeo.",
                "https://example.com/cardio-20",
                true
        ));
    }

    @Test
    void userCanRegisterLoginAndListWorkouts() throws Exception {
        String registerBody = """
                {
                  "username": "sprint1-user",
                  "password": "123456"
                }
                """;

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("sprint1-user"));

        String loginBody = """
                {
                  "username": "sprint1-user",
                  "password": "123456"
                }
                """;

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").isNotEmpty());

        mockMvc.perform(get("/workouts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].title").value("Treino Cardio 20min"))
                .andExpect(jsonPath("$.total").value(1));
    }
}