package com.codeup.trainingapp.Controllers;


import com.codeup.trainingapp.Repositories.ProviderRepository;
import com.codeup.trainingapp.models.Needs.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProviderController {
    final ProviderRepository providerDao;

    public ProviderController(ProviderRepository providerDao) {
        this.providerDao = providerDao;
    }

    @GetMapping(path= "/provider/{name}")
    public String provider(@PathVariable String name, Model model){
        model.addAttribute("provider", providerDao.findByName(name));
        return "provider/view";
    }


}
