package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.*;
import com.codeup.trainingapp.models.Wants.Gradable;
import com.codeup.trainingapp.models.Wants.Gradable_Student;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class InstructorController {

    private final CourseRepository courseDao;

    private final CurriculumRepository curriculumDao;

    private final ProviderRepository providerDao;


    private final GradableRepository gradableDao;

    private final AttendanceRepository attendanceDao;

    private final Gradable_StudentRepository gradable_studentDao;

    public InstructorController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, GradableRepository gradableDao, AttendanceRepository attendanceDao, Gradable_StudentRepository gradable_studentDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.gradableDao = gradableDao;
        this.attendanceDao = attendanceDao;
        this.gradable_studentDao = gradable_studentDao;
    }

    @GetMapping("/instructor/courses")
    public String InstructorCourseView(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        model.addAttribute("courses", courseDao.findByInstructors(user));
        return "instructor/courses";
    }

    @GetMapping("/instructor/course/{course_id}")
    public String CoursePage(Model model, @PathVariable Long course_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        if (!courseDao.findOne(course_id).getInstructors().contains(user)){
            return "redirect:/instructor/courses";
        }
        model.addAttribute("course", courseDao.findOne(course_id));
        return "instructor/course";
    }

    @GetMapping("/instructor/course/{course_id}/edit")
    public String CourseEditForm(Model model, @PathVariable Long course_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        if (!courseDao.findOne(course_id).getInstructors().contains(user)){
            return "redirect:/instructor/courses";
        }
        model.addAttribute("course", courseDao.findOne(course_id));
        return "instructor/edit_course";
    }

    @GetMapping("/instructor/curricula")
    public String InstructorCurriculaView(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        model.addAttribute("curricula", curriculumDao.findAll());
        model.addAttribute("courses", courseDao.findAll());
        return "instructor/curricula";
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}")
    public String CurriculumPage(Model model, @PathVariable Long curriculum_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        model.addAttribute("curriculum", curriculumDao.findOne(curriculum_id));
        return "instructor/curriculum";
    }

    @GetMapping("/instructor/course/add-grade/{gradable_id}")
    public String addGrade(Model model, @PathVariable Long gradable_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }

        Iterable <Gradable_Student> students = gradable_studentDao.findAllByCourse_IdAndGradeIsNull(gradable_id);
        if (students == null){
            return "sendredirect:/instructor/course" + gradable_id;
        } else {
            model.addAttribute("gradable_students", students);
            return "instructor/add-grade";
        }
    }

    @PostMapping("/instructor/add-grades/{course_id}")
    public String insertGrades(@RequestParam List<Long> grades, @PathVariable Long course_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        Iterable<Gradable_Student> students = gradable_studentDao.findAllByCourse_IdAndGradeIsNull(course_id);
       int i=0;
        for(Gradable_Student student: students){
            student.setGrade(grades.get(i));
            i++;
        }
            gradable_studentDao.save(students);


        return "redirect:/instructor/course/" + course_id;
    }

    @GetMapping("/instructor/course/grades/{gradable_id}")
    public String viewGrades(Model model, @PathVariable Long gradable_id){
        Iterable<Gradable_Student> students = gradable_studentDao.findAllByGradable_id(gradable_id);
        model.addAttribute("gradable_students", students);
        return "instructor/grade";
    }


    @GetMapping("/instructor/curriculum/create")
    public String CreateCurriculumForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        Curriculum newCurriculum = new Curriculum();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newCurriculum.setId(id);
        newCurriculum.setDescription(description);
        newCurriculum.setLearning_objectives(learning_objectives);
        newCurriculum.setName(name);
        newCurriculum.setProvider(providerDao.findOne(provider_id));
        newCurriculum.setCreationDate(date);
        newCurriculum.setUpdateDate(date);
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        Curriculum newCurriculum = new Curriculum();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newCurriculum.setDescription(description);
        newCurriculum.setLearning_objectives(learning_objectives);
        newCurriculum.setName(name);
        newCurriculum.setProvider(providerDao.findOne(provider_id));
        newCurriculum.setUpdateDate(date);
        curriculumDao.save(newCurriculum);
        return "redirect:/instructor/curriculum/" + newCurriculum.getId();
    }

    @GetMapping("/instructor/curriculum/{curriculum_id}/edit")
    public String CurriculumEditForm(Model model, @PathVariable Long curriculum_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        model.addAttribute("curriculum", curriculumDao.findOne(curriculum_id));
        return "instructor/edit_curriculum";
    }


    @GetMapping("/instructor/curriculum/{curriculum_id}/create_grade")
    public String CreateCurriculumGrade(Model model, @PathVariable Long curriculum_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        Gradable newGradable = new Gradable();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        newGradable.setName(name);
        newGradable.setWeight(weight);
        newGradable.setCurriculum(curriculum);
        newGradable.setCreationDate(date);
        newGradable.setUpdateDate(date);
        gradableDao.save(newGradable);
        return "redirect:/instructor/curriculum/" + newGradable.getCurriculum().getId();
    }

    @GetMapping("/instructor/course/{course_id}/attendance/{day}")
    public String AttendanceSheet(Model model, @PathVariable Long course_id, @PathVariable Date day){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        model.addAttribute("attendances", attendanceDao.findByDateAndCourse(day, courseDao.findOne(course_id)));
        return "instructor/attendance";
    }

    @GetMapping("/instructor/course/{course_id}/attendance_form")
    public String AttendanceForm(Model model, @PathVariable Long course_id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }
        Course course = courseDao.findOne(course_id);
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        AttendancesCreationDto attendanceForm = new AttendancesCreationDto();

        for (int i = 0; i < course.getStudents().size() ; i++ ){
            System.out.println(date);
            System.out.println(true);
            System.out.println(course.getStudents().get(i).getUser().getFullName());
            System.out.println(course.getId());
            System.out.println(course.getStudents());

            attendanceForm.addAttendance(new Attendance(date,true,course.getStudents().get(i).getUser(),course));
            System.out.println(i);
        }
        model.addAttribute("attendanceForm", attendanceForm);
        return ("instructor/create_attendance");
    }

    @PostMapping("/submit_attendance")
    public String submitAttendance(@ModelAttribute AttendancesCreationDto attendanceForm){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getRole().equals("instructor")){
            return "redirect:/";
        }

        for (int i = 0; i < attendanceForm.getAttendances().size() ; i++ ){
            System.out.println(i);
            attendanceDao.save(attendanceForm.getAttendances().get(i));
        }

        return "redirect:/instructor/course/" + attendanceForm.getAttendances().get(0).getCourse().getId();
    }

}
