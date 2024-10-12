package com.project4x.project4x.controller;

import com.project4x.project4x.entity.Admin;
import com.project4x.project4x.entity.Coach;
import com.project4x.project4x.repository.AdminRepository;
import com.project4x.project4x.repository.CoachRepository;
import com.project4x.project4x.service.MemberService;
import com.project4x.project4x.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ReservationService reservationService;

    // Show registration page
    @GetMapping("/register")
    public String showRegistration(Model model) {
        model.addAttribute("admin", new Admin());
        return "Admin/aRegPage";
    }

    // Process registration
    @PostMapping("/register")
    public String processRegistration(Admin admin, String confirmPassword, Model model) {
        if (admin.getPassword().equals(confirmPassword)) {
            adminRepository.save(admin);
            return "redirect:/admin/login";
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "Admin/aRegPage";
        }
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "Admin/loginAdmin";
    }

    // Process login credentials
    @PostMapping("/login")
    public String processLogin(String userName, String password, Model model) {
        Admin admin = adminRepository.findByUserName(userName);
        if (admin != null && admin.getPassword().equals(password)) {
            return "redirect:/admin/admin_dashboard";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "Admin/loginAdmin";
        }
    }


    // Filter by date
    @GetMapping("/admin_dashboard")
    public String getAdminDashboard(@RequestParam(value = "scheduleDate", required = false)
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate scheduleDate,
                                    Model model) {
        List<ReservationService.ReservationDetails> bookings;
        if (scheduleDate != null) {
            bookings = reservationService.getFilterByDate(scheduleDate);  // Fix: called on the instance
        } else {
            bookings = reservationService.getAllBookedSeats();
        }
        model.addAttribute("bookings", bookings);
        model.addAttribute("scheduleDate", scheduleDate);
        return "Admin/dashboard_admin";
    }


    // Filter by user name
    @PostMapping("/admin_dashboard/search")
    public String searchByUserName(@RequestParam("userName") String userName, Model model) {
        List<ReservationService.ReservationDetails> bookings;
        if (userName.isEmpty()) {
            bookings = reservationService.getAllBookedSeats();
        } else {
            bookings = reservationService.getBookingsByUserName(userName);
        }
        model.addAttribute("bookings", bookings);
        return "Admin/dashboard_admin";
    }



    // get coaches details
    @GetMapping("/coaches_details")
    public String getCoachesDetails(Model model) {
        // Fetch the list of all coaches from the repository
        List<Coach> coaches = coachRepository.findAll();

        // Add the list of coaches to the model to be displayed in the view
        model.addAttribute("coaches", coaches);

        // Return the view name where the coaches' details will be displayed
        return "Admin/Coaches_table";
    }

    // Search by UserName in Coach details
    @PostMapping("/coach_details/search")
    public String searchByUserNameCoaches(@RequestParam("userName") String userName, Model model) {
        // Check if userName is provided
        List<Coach> coaches;
        if (userName.isEmpty()) {
            // If no userName is provided, return all coaches
            coaches = coachRepository.findAll();
        } else {
            // Search coaches by userName
            coaches = coachRepository.findByUserNameContainingIgnoreCase(userName);
        }

        // Add the result to the model
        model.addAttribute("coaches", coaches);

        // Return to the coaches page with the search results
        return "Admin/Coaches_table";
    }


    // Get details of member and assigned coach
    @PostMapping("/member_details")
    public String memberDetails(@RequestParam("userName") String userName,
                                @RequestParam("id") Long id,
                                Model model) {
        List<ReservationService.ReservationDetails> members = reservationService.getMemberDetailsByUserNameAndId(userName, id);
        model.addAttribute("members", members);

        // Fetch assigned coach information (use Coach entity)
        Coach assignedCoach = reservationService.getAssignedCoachByBookingId(id);
        model.addAttribute("assignedCoach", assignedCoach);

        List<Coach> coaches = coachRepository.findAll();
        model.addAttribute("coaches", coaches);

        return "Admin/member_details";
    }



    @PostMapping("/assignCoach")
    public String assignCoachToReservation(@RequestParam("coachId") Long coachId,
                                           @RequestParam("bookingId") Long bookingId,
                                           RedirectAttributes redirectAttributes) {
        boolean success = reservationService.assignCoachToReservation(coachId, bookingId);

        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Coach successfully assigned!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to assign coach.");
        }

        return "redirect:/admin/admin_dashboard";
    }


}



