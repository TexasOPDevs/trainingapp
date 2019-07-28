package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.UserRepository;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setId(loggedIn.getId());
        user.setPassword(loggedIn.getPassword());
        user.setImg(loggedIn.getImg());
        user.setUsername(loggedIn.getUsername());
        user.setRole(loggedIn.getRole());
        userDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping("/user/update")
    public String update(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = userDao.findOne(user.getId());
        model.addAttribute("user", user1);
        return "user/update";
    }
}
