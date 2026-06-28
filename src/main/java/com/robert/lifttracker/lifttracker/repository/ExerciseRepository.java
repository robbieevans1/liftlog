package com.robert.lifttracker.lifttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robert.lifttracker.lifttracker.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
