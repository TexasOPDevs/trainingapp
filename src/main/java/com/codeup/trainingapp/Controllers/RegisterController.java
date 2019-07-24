package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.UserRepository;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private UserRepository userDao;

    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        if (userDao.findOne(user.getId()) != null){
            return "redirect:/login";
        }
        if (userDao.findByUsername(user.getUsername()) != null){
            return "redirect:/login";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setRole("student");
        userDao.save(user);
        return "redirect:/login";
    }
}
