package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.models.Needs.Curriculum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("/curricula")
    public String CurriculaView() {
        return "instructor/curricula";
    }

}
