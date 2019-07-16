package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InstructorController {

    private final CourseRepository courseDao;

    private final CurriculumRepository curriculumDao;

    private final ProviderRepository providerDao;

    public InstructorController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
    }


    @GetMapping("/instructor/courses")
    public String InstructorCourseView(Model model){
        model.addAttribute("courses", courseDao.findAll());
        return "instructor/courses";
    }

}
