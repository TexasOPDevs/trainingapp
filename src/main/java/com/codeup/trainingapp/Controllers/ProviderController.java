package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.CourseRepository;
import com.codeup.trainingapp.Repositories.CurriculumRepository;
import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.models.Needs.Curriculum;
import com.codeup.trainingapp.models.Needs.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProviderController {
    final ProviderRepository providerDao;

    final CurriculumRepository curriculumDao;

    final CourseRepository courseDao;


    public ProviderController(ProviderRepository providerDao, CurriculumRepository curriculumDao,
                              CourseRepository courseDao) {
        this.providerDao = providerDao;
        this.curriculumDao = curriculumDao;
        this.courseDao = courseDao;
    }

    @GetMapping(path= "/provider/{name}")
    public String provider(@PathVariable String name, Model model){

        model.addAttribute("provider", providerDao.findByName(name));
        model.addAttribute("courses", courseDao.findAllByCurriculum_Provider_NameOrderByStartDateAsc(name));
        return "provider/view";
    }


}
