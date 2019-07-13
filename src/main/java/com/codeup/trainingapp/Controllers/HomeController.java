package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.models.Needs.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final CourseRepository courseDao;

    public HomeController(CourseRepository courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/courses.json")
    public @ResponseBody
    Iterable<Course> viewCoursesInJSON() {
        return courseDao.findAll();
    }

    @GetMapping("/courses")
    public String courseView() {

        return "home/courses";
    }

    @GetMapping("/login")
    public String login() {

        return "home/login-register";
    }

}
