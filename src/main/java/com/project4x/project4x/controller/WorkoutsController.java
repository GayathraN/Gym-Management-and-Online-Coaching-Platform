package com.project4x.project4x.controller;

import com.project4x.project4x.DTO.WorkoutDTO;
import com.project4x.project4x.entity.AssignedWorkout;
import com.project4x.project4x.entity.Reservation;
import com.project4x.project4x.service.AssignedWorkoutService;
import com.project4x.project4x.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/workouts")
public class WorkoutsController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AssignedWorkoutService assignedWorkoutService;

    // Show next workouts dashboard
    @GetMapping("/NextWorkouts")
    public String showDashboard(@RequestParam("username") String username, @RequestParam("id") Long id, Model model) {
        List<ReservationService.ReservationDetails> members = reservationService.getMemberDetailsByUserNameAndId(username, id);
        model.addAttribute("members", members);
        return "Coach/NextWorkouts";
    }

    // Assign workouts to a member
    @PostMapping("/assign")
    public ResponseEntity<Map<String, String>> assignWorkouts(
            @RequestParam Long bookingId,
            @RequestBody List<WorkoutDTO> workoutDTOs) {

        List<AssignedWorkout> workouts = workoutDTOs.stream()
                .map(dto -> {
                    AssignedWorkout workout = new AssignedWorkout();
                    workout.setWorkoutName(dto.getWorkoutName());
                    workout.setReps(dto.getReps());
                    workout.setSets(dto.getSets());
                    workout.setDescription(dto.getDescription());
                    workout.setVideoLink(dto.getVideoLink());
                    workout.setBookingId(bookingId);
                    return workout;
                }).collect(Collectors.toList());

        assignedWorkoutService.saveAll(workouts);

        // Return a valid JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Workouts assigned successfully");
        return ResponseEntity.ok(response);
    }

}
