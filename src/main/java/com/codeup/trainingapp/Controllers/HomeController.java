package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/profile")
    public String redirect(){
        System.out.println("here's profile");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        if (user.getRole().equals("instructor")){
            return "redirect:/";
        } else if (user.getRole().equals("coordinator")){
            return "redirect:/coordinator";
        } else {
            return "redirect:/student";
        }
    }

    @GetMapping("/curricullum.json")
    public @ResponseBody Iterable<Curriculum> viewCurriculaInJSON(){
        return curriculumDao.findAll();
    }


//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "home/login-register";
//    }


    @GetMapping("/courses")
    public String courseView(Model model) {
        model.addAttribute("student", new Student());
        return "home/courses";
    }

    @PostMapping("/courses")
    private String signup(@RequestParam("course") Long id){
        studentDao.save(new Student(userDao.findOne(7L), courseDao.findOne(id), statusDao.findOne(2L)));
        return "redirect:/student";
    }

}
