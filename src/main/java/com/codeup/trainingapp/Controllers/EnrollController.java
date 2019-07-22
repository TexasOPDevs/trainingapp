package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnrollController {
    private final CourseRepository courseDao;
    private final CurriculumRepository curriculumDao;
    private final ProviderRepository providerDao;
    private final UserRepository userDao;
    private final StudentRepository studentDao;
    private final StatusRepository statusDao;


    public EnrollController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, UserRepository userDao, StudentRepository studentDao, StatusRepository statusDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.userDao = userDao;
        this.studentDao = studentDao;
        this.statusDao = statusDao;
    }

    @PostMapping("/enroll")
    private String enroll(
            @RequestParam(name = "student") Long id,
            @RequestParam(name = "course") Long course
    ) {
        System.out.println("Got here");
        Student student = studentDao.findOne(id);
        student.setCourse(courseDao.findOne(course));
        student.setStatus(statusDao.findOne(101L));
        studentDao.save(student);
        return "redirect:/instructor/courses";
    }
}
