package com.stattracker.api.cumulativestats;

import com.stattracker.api.cumulativestats.dto.CumulativePlayerStatsDTO;
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
    public CumulativePlayerStatsDTO getPlayerStatsByCategoryAndLimit(@PathVariable String category,
                                                                     @PathVariable String limit) {
        return cumulativeStatsService.getPlayerStatsByCategoryAndLimit(category, limit);
    }
}
