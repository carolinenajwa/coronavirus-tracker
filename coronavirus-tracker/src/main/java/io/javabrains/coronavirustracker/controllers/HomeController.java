package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


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

        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases =  allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        // Adding attribute.
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);

        // returns file home.html
        return "home";
    }
}
