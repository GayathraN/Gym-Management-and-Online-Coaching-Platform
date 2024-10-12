package com.project4x.project4x.repository;

import com.project4x.project4x.entity.AssignedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedWorkoutRepository extends JpaRepository<AssignedWorkout, Long> {
}
