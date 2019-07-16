package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Curriculum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    private final CourseRepository courseDao;
    private final CurriculumRepository curriculumDao;
    private final ProviderRepository providerDao;
    private final UserRepository userDao;
    private final StudentRepository studentDao;

    public StudentController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, UserRepository userDao, StudentRepository studentDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.userDao = userDao;
        this.studentDao = studentDao;
    }

    @GetMapping("/student")
    public String studentView(Model model){
        model.addAttribute(userDao.findOne(7L));
        model.addAttribute(providerDao.findByName("org_1"));
        model.addAttribute("students", studentDao.findAllByUser_Id(7L));
        return "student/profile";
    }


    @GetMapping("/allCourses.json")
    public @ResponseBody Iterable<Curriculum> viewCurriculaInJSON(){
        return curriculumDao.findAll();
    }


}
