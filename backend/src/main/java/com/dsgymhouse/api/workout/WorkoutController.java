package com.dsgymhouse.api.workout;

import com.dsgymhouse.api.workout.dto.WorkoutDetailResponse;
import com.dsgymhouse.api.workout.dto.WorkoutListItemResponse;
import com.dsgymhouse.api.workout.dto.WorkoutListResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping
    public WorkoutListResponse listWorkouts(
            @RequestParam(required = false) String goal,
            @RequestParam(required = false) Workout.WorkoutLevel level,
            @RequestParam(required = false) Integer durationMax,
            @RequestParam(required = false) Workout.WorkoutFormat format,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        validatePagination(page, pageSize);
        if (durationMax != null && durationMax < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "durationMax must be >= 1");
        }

        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));

        Specification<Workout> spec = (root, query, cb) -> cb.isTrue(root.get("published"));

        if (goal != null && !goal.isBlank()) {
            String normalizedGoal = "%" + goal.toLowerCase() + "%";
            spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("goal")), normalizedGoal));
        }
        if (level != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("level"), level));
        }
        if (durationMax != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("durationMinutes"), durationMax));
        }
        if (format != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("format"), format));
        }

        Page<Workout> workoutPage = workoutRepository.findAll(spec, pageable);
        List<WorkoutListItemResponse> items = workoutPage.getContent().stream().map(this::toListItem).toList();

        return new WorkoutListResponse(items, workoutPage.getTotalElements(), page, pageSize);
    }

    @GetMapping("/{workoutId}")
    public WorkoutDetailResponse getWorkoutById(@PathVariable Long workoutId) {
        Workout workout = workoutRepository.findByIdAndPublishedTrue(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "workout_not_found"));

        return new WorkoutDetailResponse(
                String.valueOf(workout.getId()),
                workout.getTitle(),
                workout.getGoal(),
                workout.getLevel(),
                workout.getDurationMinutes(),
                workout.getFormat(),
                workout.getInstructions(),
                workout.getContentUrl()
        );
    }

    private WorkoutListItemResponse toListItem(Workout workout) {
        return new WorkoutListItemResponse(
                String.valueOf(workout.getId()),
                workout.getTitle(),
                workout.getGoal(),
                workout.getLevel(),
                workout.getDurationMinutes(),
                workout.getFormat()
        );
    }

    private void validatePagination(int page, int pageSize) {
        if (page < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "page must be >= 1");
        }
        if (pageSize < 1 || pageSize > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "pageSize must be between 1 and 100");
        }
    }
}