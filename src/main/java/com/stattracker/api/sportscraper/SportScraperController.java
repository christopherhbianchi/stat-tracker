package com.stattracker.api.sportscraper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Christopher Bianchi
 **/
@RestController
@RequestMapping("teams")
public class SportScraperController {

    private final SportScraperService sportScraperService;
    public SportScraperController (SportScraperService sportScraperService) {
        this.sportScraperService = sportScraperService;
    }

    @GetMapping
    public List<String> getTeams() {

        return sportScraperService.getTeams();
    }

    @GetMapping("/{divisionName}")
    public List<String> getTeamsByDivisionName(@PathVariable String divisionName) {

        return sportScraperService.getTeamsByDivisionName(divisionName);
    }


}
