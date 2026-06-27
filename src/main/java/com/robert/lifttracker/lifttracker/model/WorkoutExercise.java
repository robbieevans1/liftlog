package com.robert.lifttracker.lifttracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkoutExercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer exerciseOrder;

  private Integer targetSets;
  private Integer targetReps;

  @ManyToOne
  @JoinColumn(name = "workout_id")
  private Workout workout;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private Exercise exercise;

  public WorkoutExercise() {
  }

  public WorkoutExercise(Workout workout, Exercise exercise, Integer exerciseOrder, Integer targetSets,
      Integer targetReps) {
    this.workout = workout;
    this.exercise = exercise;
    this.exerciseOrder = exerciseOrder;
    this.targetSets = targetSets;
    this.targetReps = targetReps;
  }

  public Long getId() {
    return id;
  }

  public Integer getExerciseOrder() {
    return exerciseOrder;
  }

  public Integer getTargetSets() {
    return targetSets;
  }

  public Integer getTargetReps() {
    return targetReps;
  }

  public Workout getWorkout() {
    return workout;
  }

  public Exercise getExercise() {
    return exercise;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setExerciseOrder(Integer exerciseOrder) {
    this.exerciseOrder = exerciseOrder;
  }

  public void setTargetSets(Integer targetSets) {
    this.targetSets = targetSets;
  }

  public void setTargetReps(Integer targetReps) {
    this.targetReps = targetReps;
  }

  public void setWorkout(Workout workout) {
    this.workout = workout;
  }

  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }
}
