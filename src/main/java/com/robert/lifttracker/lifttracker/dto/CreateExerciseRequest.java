package com.robert.lifttracker.lifttracker.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateExerciseRequest(
        @NotBlank(message = "Exercise name is required")
        String name,

        String muscleGroup,

        String equipment
) {
}