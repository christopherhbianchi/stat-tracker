package com.stattracker.api.cumulativestats;

import com.stattracker.api.cumulativestats.dto.CumulativeStatDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/category/{category}/limit/{limit}")
    public CumulativeStatDTO getPlayerStatsByCategoryAndLimit(@PathVariable String category,
                                                              @PathVariable String limit) {
        return cumulativeStatsService.getPlayerStatsByCategoryAndLimit(category, limit);
    }

    @GetMapping("/team/{teamName}")
    public CumulativeStatDTO getPlayerStatsByTeamName(@PathVariable String teamName) {
        return cumulativeStatsService.getPlayerStatsByTeamName(teamName);
    }
}
