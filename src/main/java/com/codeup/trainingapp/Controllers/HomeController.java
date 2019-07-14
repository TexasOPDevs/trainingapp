package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.UserRepository;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final CourseRepository courseDao;
    private final UserRepository userDao;

    public HomeController(CourseRepository courseDao, UserRepository userDao) {
        this.courseDao = courseDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String landing(){
        return "home/landing-page";
    }

    @GetMapping("/courses")
    public String courseView() {

        return "home/courses";
    }

    @GetMapping("/courses.json")
    public @ResponseBody
    Iterable<Course> viewCoursesInJSON() {
        return courseDao.findAll();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "home/login-register";
    }

    @PostMapping("/login")
    private String register(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/courses";
    }

}
