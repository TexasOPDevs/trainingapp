package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.models.Needs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "home/login-register";
    }
}
