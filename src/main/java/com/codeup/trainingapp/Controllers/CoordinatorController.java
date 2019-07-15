package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.Repositories.UserRepository;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Provider;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class CoordinatorController {

    private final CourseRepository courseDao;

    private final CurriculumRepository curriculumDao;

    private final ProviderRepository providerDao;

    private final UserRepository userDao;

    public CoordinatorController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, UserRepository userDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;

        this.userDao = userDao;
    }

    @GetMapping("/user.json")
    public @ResponseBody Iterable<User> viewUsersInJSON(){
        return userDao.findAll();
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





    @GetMapping("/coordinator")
    public String coordinatorPortal(Model model){

        Iterable<Curriculum> curricula = curriculumDao.findAllByProvider_Id(2L);

        model.addAttribute("curricula", curricula);

        model.addAttribute("course", new Course());
        return "coordinator/profile";
    }


    @PostMapping("/coordinator")
    @ResponseBody
    public void createACourse(@ModelAttribute Course course)
    {
        System.out.println("course.getId() + \" \"+ course.getInstructors() = " + course.getId() + " "+ course.getInstructors());
        courseDao.save(course);
    }

}

