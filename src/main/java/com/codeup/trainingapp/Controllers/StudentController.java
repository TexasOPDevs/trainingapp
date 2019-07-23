package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.*;
import com.codeup.trainingapp.models.Needs.Attendance;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import com.codeup.trainingapp.models.Wants.Gradable_Student;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {
    private final CourseRepository courseDao;
    private final CurriculumRepository curriculumDao;
    private final ProviderRepository providerDao;
    private final UserRepository userDao;
    private final StudentRepository studentDao;


    public StudentController(CourseRepository courseDao, CurriculumRepository curriculumDao, ProviderRepository providerDao, UserRepository userDao, StudentRepository studentDao) {
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.providerDao = providerDao;
        this.userDao = userDao;
        this.studentDao = studentDao;
    }

    @GetMapping("/student")
    public String studentView(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        Iterable<Student> students = studentDao.findAllByUser_Id(user.getId());
        List<Double> attendanceAvgs = new ArrayList<>();
        int i = 0;
        double count = 0;
        for (Student student : students) {
            if (student.getUser().getId().equals(user.getId())) {
                for (Attendance attend : student.getUser().getAttendances()) {
                    i++;
                    if (attend.getPresent()) {
                        count += 1;
                    }
                }
            }

        }
        List<Double> gradesAvgs = new ArrayList<>();
        double total = 0;
        for (Student student : students) {
            if (student.getUser().getId().equals(user.getId())) {
                for (Gradable_Student grade : student.getUser().getGradable_students()) {
                    if (grade.getGrade() != null) {
                        total += (grade.getGrade() * (((float) grade.getGradable().getWeight() / 100)));
                        System.out.println(total);
                    }
                }
            }
        }
        attendanceAvgs.add(count / i);
        gradesAvgs.add(total);
        System.out.println(gradesAvgs);
        model.addAttribute("attendanceAvgs", attendanceAvgs);
        model.addAttribute("gradesAvgs", gradesAvgs);
        model.addAttribute("students", students);
        return "student/profile";
    }


    @GetMapping("/allCourses.json")
    public @ResponseBody
    Iterable<Curriculum> viewCurriculaInJSON() {
        return curriculumDao.findAll();
    }


}
