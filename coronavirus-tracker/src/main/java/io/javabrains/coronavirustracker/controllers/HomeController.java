package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



// Render UI in HTML
@Controller
public class HomeController {

    // Since Service in Coronavirusdataservice.java, we can Autowired
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    // Map to root URL - When there is a @GetMapping to "/"
    // which is the root url return the home template

    @GetMapping("/")
    public String home(Model model) {

        // Adding attribute.
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        // returns file home.html
        return "home";
    }
}
