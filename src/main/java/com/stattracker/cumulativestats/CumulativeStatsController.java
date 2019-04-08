package com.stattracker.cumulativestats;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Christopher Bianchi
 **/
@RestController
@RequestMapping("stats/player")
public class CumulativeStatsController {

    private final CumulativeStatsService cumulativeStatsService;

    public CumulativeStatsController(CumulativeStatsService cumulativeStatsService){
        this.cumulativeStatsService = cumulativeStatsService;
    }
}
