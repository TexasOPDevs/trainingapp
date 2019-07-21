package com.codeup.trainingapp.Controllers;

import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import com.codeup.trainingapp.models.Wants.Gradable;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final StudentRepository studentDao;

    private final UserRepository userDao;

    private final StatusRepository statusDao;

    private final GradableRepository gradableDao;

    public InstructorController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, GradableRepository gradableDao, UserRepository userDao, StudentRepository studentDao, StatusRepository statusDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.studentDao = studentDao;
        this.userDao = userDao;
        this.statusDao = statusDao;
        this.gradableDao = gradableDao;
    }


    @GetMapping("/instructor/courses")
    public String InstructorCourseView(Model model) {
        model.addAttribute("curricula", curriculumDao.findAll());
        model.addAttribute("courses", courseDao.findAll());
        return "instructor/courses";
    }

    @GetMapping("/instructor/applicants")
    public String InstructorApplicantsView(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.findOne(user.getId()));
        model.addAttribute("curricula", curriculumDao.findAll());
        model.addAttribute("courses", courseDao.findAll());
        model.addAttribute("students", studentDao.findAll());
        return "instructor/applicants";
    }

    @PostMapping("/applicants")
    private String enroll(@RequestParam(name = "course") Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = new Student();
        System.out.println("test postmap");
        student.setUser(userDao.findOne(user.getId()));
        student.setCourse(courseDao.findOne(id));
        student.setStatus(statusDao.findOne(101L));
        studentDao.save(student);
        return"redirect:/instructor/applicants";

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
    public String CreateCurriculumForm(Model model){
        model.addAttribute("curriculum", new  Curriculum());
        return "instructor/create_curriculum";
    }

    @PostMapping("/curriculum/create")
    public String CreateCurriculumMethod(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "learning_objectives") String learning_objectives,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "provider") Long provider_id
    ) {
        Curriculum newCurriculum = new Curriculum();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newCurriculum.setId(id);
        newCurriculum.setDescription(description);
        newCurriculum.setLearning_objectives(learning_objectives);
        newCurriculum.setName(name);
        newCurriculum.setProvider(providerDao.findOne(provider_id));
        newCurriculum.setCreation_date(date);
        newCurriculum.setUpdate_date(date);
        curriculumDao.save(newCurriculum);
        return "redirect:/instructor/curriculum/" + id;
    }



    @PostMapping("/curriculum/edit")
    public String CreateCurriculumMethod(
            @RequestParam(name = "description") String description,
            @RequestParam(name = "learning_objectives") String learning_objectives,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "provider.id") Long provider_id
    ) {
        Curriculum newCurriculum = new Curriculum();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newCurriculum.setDescription(description);
        newCurriculum.setLearning_objectives(learning_objectives);
        newCurriculum.setName(name);
        newCurriculum.setProvider(providerDao.findOne(provider_id));
        newCurriculum.setUpdate_date(date);
        curriculumDao.save(newCurriculum);
        return "redirect:/instructor/curriculum/" + newCurriculum.getId();
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}/edit")
    public String CurriculumEditForm(Model model, @PathVariable Long curriculum_id){
        model.addAttribute("curriculum", curriculumDao.findOne(curriculum_id));
        return "instructor/edit_curriculum";
    }


    @GetMapping("/instructor/curriculum/{curriculum_id}/create_grade")
    public String CreateCurriculumGrade(Model model, @PathVariable Long curriculum_id){
        Gradable newGradable = new Gradable();
        newGradable.setCurriculum(curriculumDao.findOne(curriculum_id));
        model.addAttribute("gradable", newGradable);
        return "instructor/add_gradable";
    }


    @PostMapping("/curriculum/create_grade")
    public String CreateCurriculumMethod(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "weight") int weight,
            @RequestParam(name = "curriculum") Curriculum curriculum
            ){
        Gradable newGradable = new Gradable();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newGradable.setName(name);
        newGradable.setWeight(weight);
        newGradable.setCurriculum(curriculum);
        newGradable.setCreation_date(date);
        newGradable.setUpdate_date(date);
        gradableDao.save(newGradable);
        return "redirect:/instructor/curriculum/" + newGradable.getCurriculum().getId();
    }

}
