package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoordinatorController {

    private final CourseRepository courseDao;

    private final CurriculumRepository curriculumDao;

    private final ProviderRepository providerDao;

    public CoordinatorController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        }

            @GetMapping("/curricula.json")
            public @ResponseBody Iterable<Curriculum> viewCurriculaInJSON(){
            return curriculumDao.findAll();
        }

            @GetMapping("/provider.json")
            public @ResponseBody Provider viewProviderInJSON(){
                return providerDao.findOne(2L);
            }

            @GetMapping("/course.json")
            public @ResponseBody Iterable<Course> viewCoursesInJSON() {
                return courseDao.findAll();
            }

            @GetMapping("/coordinator/profile")
            public String coordinatorPortal(){

            return "coordinator/profile";
        }

}
