package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
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


    @GetMapping("/courses")
    public String courseView(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", userDao.findOne(user.getId()));
        } else{
            model.addAttribute("user", new User());
        }
        model.addAttribute("courses", courseDao.findAllByStatus_IdOrderByStartDateAsc(204L));
        model.addAttribute("student", studentDao.findAll());
        return "home/courses";
    }

    @PostMapping("/apply")
    private String signup(@RequestParam(name="course") Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = new Student();
        if(studentDao.findByCourse_IdAndUser_IdAndStatus_Id(id, user.getId(), 102L).toString().equals("[]")) {
            System.out.println("got here");
            student.setUser(userDao.findOne(user.getId()));
            student.setCourse(courseDao.findOne(id));
            student.setStatus(statusDao.findOne(102L));
            studentDao.save(student);
        }
        return "redirect:/student";
    }

}
