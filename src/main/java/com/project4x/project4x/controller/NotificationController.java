package com.project4x.project4x.controller;

import com.project4x.project4x.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
@Controller
public class NotificationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/pdf")
    public String generatePdf(Model model,
                              @RequestParam Integer reservationNumber,
                              @RequestParam LocalDate scheduleDate,
                              @RequestParam String userName,
                              @RequestParam String fullName,
                              @RequestParam String contactNumber) {

        // Create a new ReservationDetails object with the passed parameters
        ReservationService.ReservationDetails reservationDetails = new ReservationService.ReservationDetails(
                 reservationNumber, scheduleDate, userName, fullName, contactNumber);

        // Add the reservation details to the model to pass to the Thymeleaf template
        model.addAttribute("reservation", reservationDetails);

        return "Pdf"; // Return the Pdf.html Thymeleaf template
    }

}
