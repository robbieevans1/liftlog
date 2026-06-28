package com.robert.lifttracker.lifttracker.repository;

import com.robert.lifttracker.lifttracker.model.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {
  List<WorkoutExercise> findByWorkoutIdOrderByExerciseOrderAsc(Long workoutId);

  Optional<WorkoutExercise> findTopByWorkoutIdOrderByExerciseOrderDesc(Long workoutId);

  Optional<WorkoutExercise> findByIdAndWorkoutId(Long id, Long workoutId);

  boolean existsByWorkoutIdAndExerciseId(Long workoutId, Long exerciseId);

  boolean existsByExerciseId(Long exerciseId);
}