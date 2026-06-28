package com.robert.lifttracker.lifttracker.dto;

public record WorkoutExerciseResponse(
        Long id,
        Integer exerciseOrder,
        Integer targetSets,
        Integer targetReps,
        ExerciseResponse exercise
) {
        
}
