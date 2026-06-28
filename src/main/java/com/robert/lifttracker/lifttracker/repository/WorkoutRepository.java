package com.robert.lifttracker.lifttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robert.lifttracker.lifttracker.model.Workout;;

public interface WorkoutRepository extends JpaRepository<Workout,Long>{
  
}
