package com.robert.lifttracker.lifttracker.dto;

import java.util.List;

public record WorkoutResponse(
        Long id,
        String name,
        String description,
        List<WorkoutExerciseResponse> exercises
) {
}