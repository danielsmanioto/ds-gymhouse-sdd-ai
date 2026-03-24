package com.dsgymhouse.api.workout;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = WorkoutController.class)
@AutoConfigureMockMvc(addFilters = false)
class WorkoutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WorkoutRepository workoutRepository;

    @Test
    void listWorkoutsReturnsPaginatedCatalog() throws Exception {
        Workout workout = sampleWorkout(10L);
        Page<Workout> page = new PageImpl<>(List.of(workout), PageRequest.of(0, 20), 1);

        when(workoutRepository.findAll(anySpecification(), any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/workouts")
                        .param("goal", "força")
                        .param("page", "1")
                        .param("pageSize", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(1))
                .andExpect(jsonPath("$.page").value(1))
                .andExpect(jsonPath("$.pageSize").value(20))
                .andExpect(jsonPath("$.items[0].id").value("10"))
                .andExpect(jsonPath("$.items[0].title").value("Treino Full Body"))
                .andExpect(jsonPath("$.items[0].level").value("iniciante"))
                .andExpect(jsonPath("$.items[0].format").value("video"));
    }

    @Test
    void getWorkoutByIdReturnsDetail() throws Exception {
        when(workoutRepository.findByIdAndPublishedTrue(10L)).thenReturn(Optional.of(sampleWorkout(10L)));

        mockMvc.perform(get("/workouts/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("10"))
                .andExpect(jsonPath("$.title").value("Treino Full Body"))
                .andExpect(jsonPath("$.instructions").value("Faça 3 séries de 12 repetições."));
    }

    @Test
    void getWorkoutByIdNotFound() throws Exception {
        when(workoutRepository.findByIdAndPublishedTrue(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/workouts/999"))
                .andExpect(status().isNotFound());
    }

    private Workout sampleWorkout(Long id) {
        Workout workout = new Workout(
                "Treino Full Body",
                "força",
                Workout.WorkoutLevel.iniciante,
                30,
                Workout.WorkoutFormat.video,
                "Faça 3 séries de 12 repetições.",
                "https://example.com/workouts/10",
                true
        );
        workout.setId(id);
        return workout;
    }

    @SuppressWarnings("unchecked")
    private Specification<Workout> anySpecification() {
        return any(Specification.class);
    }
}