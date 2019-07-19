package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Course;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Provider;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;


@Controller
public class CoordinatorController {

    private final CourseRepository courseDao;

    private final CurriculumRepository curriculumDao;

    private final ProviderRepository providerDao;

    private final UserRepository userDao;

    private final StatusRepository StatusDao;

    private final InstructorRepository instructorDao;

    private final MaterialRepository materialsDao;

    public CoordinatorController(CourseRepository courseDao, CurriculumRepository curriculumDao,
                                 ProviderRepository providerDao, UserRepository userDao, StatusRepository statusDao,
                                 InstructorRepository instructorDao, MaterialRepository materialsDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.userDao = userDao;
        this.StatusDao = statusDao;
        this.instructorDao = instructorDao;
        this.materialsDao = materialsDao;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("coordinator")){
            return "redirect:/profile";
        }

        Provider provider = providerDao.findByCoordinator_Id(32L);

        Iterable<Curriculum> curricula = curriculumDao.findAllByProvider_Id(provider.getId());
        model.addAttribute("provider", provider);
        model.addAttribute("curricula", curricula);
        model.addAttribute("curriculum", new Curriculum());
        model.addAttribute("course", new Course());
        model.addAttribute("materials", materialsDao.findAll());
        return "coordinator/profile";
    }

    @PostMapping("/newCourse")
    public String createACur(@ModelAttribute Curriculum curriculum){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!user.getRole().equals("coordinator")){
            return "redirect:/profile";
        }
        Provider provider = providerDao.findByCoordinator_Id(32L);
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        curriculum.setCreation_date(date);
        curriculum.setProvider(provider);
        curriculumDao.save(curriculum);

        return "redirect:/coordinator";
    }

    @GetMapping("/makeInstructor")
    public String makeInstructor( @RequestParam(required = false) Long emp_id){
//        User curuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (!curuser.getRole().equals("coordinator")){
//            return "redirect:/profile";
//        }
        User user = userDao.findOne(emp_id);
        user.setRole("instructor");
        System.out.println("got here! " + user.getFirst_name());
        userDao.save(user);
        return "redirect:/coordinator";
    }


    @PostMapping("/coordinator")
    public String createACourse(@ModelAttribute Course course)
    {
        User curuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!curuser.getRole().equals("coordinator")){
            return "redirect:/profile";
        }

            course.setStatus(StatusDao.findOne(202L));
            courseDao.save(course);

        return "redirect:/coordinator";
    }

//    @PostMapping(value = "/saveEmployee")
//    public String makeInstructor (@RequestParam Long emp_id){
//
//        return "redirect:/coordinator";
//    }

}

