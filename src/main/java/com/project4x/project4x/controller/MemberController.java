package com.project4x.project4x.controller;

import com.project4x.project4x.entity.AssignedWorkout;
import com.project4x.project4x.entity.Member;
import com.project4x.project4x.entity.Reservation;
import com.project4x.project4x.repository.AssignedWorkoutRepository;
import com.project4x.project4x.repository.ReservationRepository;
import com.project4x.project4x.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
@SessionAttributes("member")  // Store 'member' in the session
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AssignedWorkoutRepository assignedWorkoutRepository;

    // Step 1: Show registration step 1 page
    @GetMapping("/register/step1")
    public String showRegistrationStep1(Model model) {
        model.addAttribute("member", new Member());
        return "Member/mRegpage1";
    }

    // Step 1: Process registration step 1 data and go to step 2
    @PostMapping("/register/step1")
    public String processRegistrationStep1(@ModelAttribute("member") Member member, Model model) {
        model.addAttribute("member", member);
        return "Member/mRegpage2";
    }

    // Step 2: Process registration step 2 data and go to step 3
    @PostMapping("/register/step2")
    public String processRegistrationStep2(@ModelAttribute("member") Member member, Model model) {
        model.addAttribute("member", member);
        return "Member/mRegpage3";
    }

    // Step 3: Finalize registration and save the member
    @PostMapping("/register/step3")
    public String processRegistrationStep3(@ModelAttribute("member") Member member, SessionStatus status) {
        memberService.saveMember(member);
        status.setComplete();  // Clear the session attributes
        return "redirect:/member/login";
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("member", new Member());
        return "Member/loginMember";
    }

    // Process login credentials
    @PostMapping("/login")
    public String processLogin(@RequestParam String userName, @RequestParam String password, Model model, HttpSession session) {
        var member = memberService.findByUserNameAndPassword(userName, password);
        if (member.isPresent()) {
            session.setAttribute("userName", userName); // Store username in session
            return "redirect:/member/dashboard";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "Member/loginMember";
        }
    }

    // Show dashboard home page
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName"); // Retrieve username from session
        if (userName != null) {
            LocalDate today = LocalDate.now(); // Get the current date

            // Fetch the latest reservation with a schedule date >= today
            Optional<Reservation> latestReservation = reservationRepository
                    .findTopByUserNameAndScheduleDateGreaterThanEqualOrderByScheduleDateAsc(userName, today);

            if (latestReservation.isPresent()) {
                Reservation reservation = latestReservation.get();
                model.addAttribute("reservation", reservation); // Add reservation to model

                // Fetch assigned workouts using the reservation ID
                List<AssignedWorkout> workouts = assignedWorkoutRepository
                        .findByBookingId(reservation.getId());

                if (!workouts.isEmpty()) {
                    model.addAttribute("workouts", workouts); // Add workout list to model
                } else {
                    model.addAttribute("message", "No assigned workouts found for this reservation.");
                }
            } else {
                model.addAttribute("message", "No upcoming reservations found.");
            }
            return "Member/dashboard_member"; // Render dashboard template
        } else {
            model.addAttribute("error", "Session expired. Please log in again.");
            return "Member/loginMember";
        }
    }




    // Show dashboard dashboard_reservation page
    @GetMapping("/dashboard_reservation")
    public String showDashboardReservation(Model model, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if (userName != null){
            model.addAttribute("userName",userName);
        }
        return "Member/dashboard_reservation";
    }


    // Logout
    @PostMapping("/logout")
    public String logoutMember(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }


}
