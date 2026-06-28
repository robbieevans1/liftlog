package com.robert.lifttracker.lifttracker.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateWorkoutRequest(
  @NotBlank(message = "Workout name is required")
  String name,
  String description
) {
  
}
