package com.project4x.project4x.controller;

import com.project4x.project4x.entity.AssignedWorkout;
import com.project4x.project4x.entity.Reservation;
import com.project4x.project4x.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutsController {

    @Autowired
    ReservationService reservationService;

    // Show next workouts dashboard
    @GetMapping("/NextWorkouts")
    public String showDashboard(@RequestParam("username") String username, @RequestParam("id") Long id, Model model) {
        List<ReservationService.ReservationDetails> members = reservationService.getMemberDetailsByUserNameAndId(username, id);
        model.addAttribute("members", members);
        return "Coach/NextWorkouts";
    }

    // Assign workouts to a member
    @PostMapping("/assign")
    public String assignWorkouts(@RequestParam("bookingId") Long bookingId,
                                 @RequestParam("workouts") List<AssignedWorkout> workouts) {
        try {
            // Assign workouts to the specified reservation
            reservationService.assignWorkoutsToReservation(bookingId, workouts);
            return "redirect:/workouts/NextWorkouts";
        } catch (Exception e) {
            // Handle error (e.g., logging)
            e.printStackTrace();
            return "redirect:/workouts/NextWorkouts";
        }
    }
}
