package com.robert.lifttracker.lifttracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String muscleGroup;
  private String equipment;

  private LocalDateTime createdAt = LocalDateTime.now();

  @OneToMany(mappedBy = "exercise")
  private List<WorkoutExercise> workoutExercises = new ArrayList<>();

  public Exercise() {
  }

  public Exercise(String name, String muscleGroup, String equipment) {
    this.name = name;
    this.muscleGroup = muscleGroup;
    this.equipment = equipment;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMuscleGroup() {
    return muscleGroup;
  }

  public String getEquipment() {
    return equipment;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public List<WorkoutExercise> getWorkoutExercises() {
    return workoutExercises;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMuscleGroup(String muscleGroup) {
    this.muscleGroup = muscleGroup;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
    this.workoutExercises = workoutExercises;
  }
}
