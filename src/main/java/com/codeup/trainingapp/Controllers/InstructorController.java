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
        model.addAttribute("curricula", curriculumDao.findAll());
        model.addAttribute("courses", courseDao.findAll());
        return "instructor/courses";
    }

    @GetMapping("/instructor/course/{course_id}")
    public String CoursePage(Model model, @PathVariable Long course_id){
        model.addAttribute("course", courseDao.findOne(course_id));
        return "instructor/course";
    }

    @GetMapping("/instructor/course/{course_id}/edit")
    public String CourseEditForm(Model model, @PathVariable Long course_id){
        model.addAttribute("course", courseDao.findOne(course_id));
        return "instructor/edit_course";
    }

    @GetMapping("/instructor/curricula")
    public String InstructorCurriculaView(Model model){
        model.addAttribute("curricula", curriculumDao.findAll());
        model.addAttribute("courses", courseDao.findAll());
        return "instructor/curricula";
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}")
    public String CurriculumPage(Model model, @PathVariable Long curriculum_id){
        model.addAttribute("curriculum", curriculumDao.findOne(curriculum_id));
        return "instructor/curriculum";
    }

    @GetMapping("/instructor/curriculum/create")
    public String CurriculumCreateForm(){
        return "instructor/create_curriculum";
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}/edit")
    public String CurriculumEditForm(Model model, @PathVariable Long curriculum_id){
        model.addAttribute("course", curriculumDao.findOne(curriculum_id));
        return "instructor/edit_curriculum";
    }

}
