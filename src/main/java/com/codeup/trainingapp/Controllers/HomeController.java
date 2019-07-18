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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", userDao.findOne(user.getId()));
        }
        model.addAttribute("user", new User());
        model.addAttribute("courses", courseDao.findAllByStatus_Id(204L));
        model.addAttribute("student", studentDao.findAll());
        return "home/courses";
    }

    @GetMapping("/apply")
    private String signup(@RequestParam(name="course") Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = new Student();
        student.setUser(userDao.findOne(user.getId()));
        student.setCourse(courseDao.findOne(id));
        student.setStatus(statusDao.findOne(1L));
        if(studentDao.findByCourse_IdAndStatus_Id(id, 1L) == null) {
            studentDao.save(student);
        }
        return "redirect:/student";
    }

}
