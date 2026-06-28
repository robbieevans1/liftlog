package com.robert.lifttracker.lifttracker.dto;

import jakarta.validation.constraints.Min;

public record AssignExerciseRequest(
        @Min(value = 1, message = "Exercise order must be at least 1")
        Integer exerciseOrder,

        @Min(value = 1, message = "Target sets must be at least 1")
        Integer targetSets,

        @Min(value = 1, message = "Target reps must be at least 1")
        Integer targetReps
) {
}
