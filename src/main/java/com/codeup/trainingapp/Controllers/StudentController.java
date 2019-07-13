package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.models.Needs.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    private final CourseRepository courseDao;

    public StudentController(CourseRepository courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/course.json")
    public @ResponseBody
    Iterable<Course> viewCoursesInJSON() {
        return courseDao.findAll();
    }

    @GetMapping("/coordinator/profile")
    public String coordinatorPortal(){

        return "coordinator/profile";
    }

}
