package com.dsgymhouse.api.workout.dto;

import com.dsgymhouse.api.workout.Workout;

public record WorkoutDetailResponse(
        String id,
        String title,
        String goal,
        Workout.WorkoutLevel level,
        Integer durationMinutes,
        Workout.WorkoutFormat format,
        String instructions,
        String contentUrl
) {
}