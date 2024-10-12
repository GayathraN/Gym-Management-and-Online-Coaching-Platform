package com.project4x.project4x.controller;

import com.project4x.project4x.entity.Member;
import com.project4x.project4x.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/member")
@SessionAttributes("member")  // Store 'member' in the session
public class MemberController {

    @Autowired
    private MemberService memberService;

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
            model.addAttribute("error", "Invalid credentials");
            return "Member/loginMember";
        }
    }

    // Show dashboard home page
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "Member/dashboard_member";
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
