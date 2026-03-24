package com.dsgymhouse.api.workout.dto;

import java.util.List;

public record WorkoutListResponse(
        List<WorkoutListItemResponse> items,
        long total,
        int page,
        int pageSize
) {
}