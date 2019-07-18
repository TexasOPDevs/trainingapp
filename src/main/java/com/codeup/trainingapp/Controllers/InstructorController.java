package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.models.Needs.Curriculum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

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
    public String CreateCurriculumForm(){
        return "instructor/create_curriculum";
    }

    @PostMapping("/create_curriculum")
    public String CreateCurriculumMethod(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "certification") String certification,
            @RequestParam(name = "course_outline") String course_outline,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "learning_objectives") String learning_objectives,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "provider_id") Long provider_id
    ) {
        Curriculum newCurriculum = new Curriculum();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newCurriculum.setId(id);
        newCurriculum.setCertification(certification);
        newCurriculum.setCourse_outline(course_outline);
        newCurriculum.setDescription(description);
        newCurriculum.setLearning_objectives(learning_objectives);
        newCurriculum.setName(name);
        newCurriculum.setProvider(providerDao.findOne(provider_id));
        newCurriculum.setCreation_date(date);
        newCurriculum.setUpdate_date(date);
        curriculumDao.save(newCurriculum);
        return "redirect:/instructor/curriculum/" + id;
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}/edit")
    public String CurriculumEditForm(Model model, @PathVariable Long curriculum_id){
        model.addAttribute("course", curriculumDao.findOne(curriculum_id));
        return "instructor/edit_curriculum";
    }

}
