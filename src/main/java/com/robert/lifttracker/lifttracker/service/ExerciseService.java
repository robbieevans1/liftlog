package com.robert.lifttracker.lifttracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robert.lifttracker.lifttracker.dto.CreateExerciseRequest;
import com.robert.lifttracker.lifttracker.dto.ExerciseResponse;
import com.robert.lifttracker.lifttracker.exception.BadRequestException;
import com.robert.lifttracker.lifttracker.exception.ResourceNotFoundException;
import com.robert.lifttracker.lifttracker.model.Exercise;
import com.robert.lifttracker.lifttracker.repository.ExerciseRepository;
import com.robert.lifttracker.lifttracker.repository.WorkoutExerciseRepository;

@Service
public class ExerciseService {

  private final ExerciseRepository exerciseRepository;
  private final WorkoutExerciseRepository workoutExerciseRepository;

  public ExerciseService(
      ExerciseRepository exerciseRepository,
      WorkoutExerciseRepository workoutExerciseRepository) {
    this.exerciseRepository = exerciseRepository;
    this.workoutExerciseRepository = workoutExerciseRepository;
  }

  public List<ExerciseResponse> getAllExercises() {
    return exerciseRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
  }

  public ExerciseResponse getExerciseById(Long id) {
    Exercise exercise = findExerciseById(id);
    return toResponse(exercise);
  }

  public ExerciseResponse createExercise(CreateExerciseRequest request) {
    Exercise exercise = new Exercise(
        request.name(),
        request.muscleGroup(),
        request.equipment());

    Exercise savedExercise = exerciseRepository.save(exercise);

    return toResponse(savedExercise);
  }

  public ExerciseResponse updateExercise(Long id, CreateExerciseRequest request) {
    Exercise exercise = findExerciseById(id);

    exercise.setName(request.name());
    exercise.setMuscleGroup(request.muscleGroup());
    exercise.setEquipment(request.equipment());

    Exercise savedExercise = exerciseRepository.save(exercise);

    return toResponse(savedExercise);
  }

  public void deleteExercise(Long id) {
    Exercise exercise = findExerciseById(id);

    boolean isAssignedToWorkout = workoutExerciseRepository.existsByExerciseId(id);

    if (isAssignedToWorkout) {
      throw new BadRequestException(
          "Cannot delete exercise because it is assigned to a workout. Remove it from workouts first.");
    }

    exerciseRepository.delete(exercise);
  }

  private Exercise findExerciseById(Long id) {
    return exerciseRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with id: " + id));
  }

  private ExerciseResponse toResponse(Exercise exercise) {
    return new ExerciseResponse(
        exercise.getId(),
        exercise.getName(),
        exercise.getMuscleGroup(),
        exercise.getEquipment());
  }
}
