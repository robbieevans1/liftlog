package com.robert.lifttracker.lifttracker.dto;

public record ExerciseResponse(
        Long id,
        String name,
        String muscleGroup,
        String equipment
) {
}
