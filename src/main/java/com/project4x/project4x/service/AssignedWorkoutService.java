package com.project4x.project4x.service;

import com.project4x.project4x.entity.AssignedWorkout;
import com.project4x.project4x.repository.AssignedWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignedWorkoutService {

    @Autowired
    private AssignedWorkoutRepository assignedWorkoutRepository;

    public AssignedWorkout saveWorkout(AssignedWorkout workout) {
        return assignedWorkoutRepository.save(workout);
    }
}