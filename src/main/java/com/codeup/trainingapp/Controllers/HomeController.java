package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final CurriculumRepository curriculumDao;
    private final UserRepository userDao;
    private final StudentRepository studentDao;
    private final CourseRepository courseDao;
    private final StatusRepository statusDao;


    public HomeController(CurriculumRepository curriculumDao, UserRepository userDao, StudentRepository studentDao, CourseRepository courseDao, StatusRepository statusDao) {
        this.curriculumDao = curriculumDao;
        this.userDao = userDao;
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.statusDao = statusDao;
    }

    @GetMapping("/")
    public String landing(){
        return "home/landing-page";
    }



    @GetMapping("/curricullum.json")
    public @ResponseBody Iterable<Curriculum> viewCurriculaInJSON(){
        return curriculumDao.findAll();
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
    @GetMapping("/courses")
    public String courseView() {
        return "home/courses";
    }

    @PostMapping("/courses")
    private String signup(@RequestParam(name="course") Long id){
        Student student = new Student();
        student.setUser(userDao.findOne(7L));
        student.setCourse(courseDao.findOne(id));
        student.setStatus(statusDao.findOne(1L));
        studentDao.save(student);
        return "redirect:/student";
    }

}
