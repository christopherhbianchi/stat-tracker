package com.stattracker.cumulativestats;

import com.stattracker.cumulativestats.dto.CumulativePlayerStatsDTO;

/**
 * @author Christopher Bianchi
 **/
public interface CumulativeStatsService {
    CumulativePlayerStatsDTO getPlayerStatsByCategory(String category);
    CumulativePlayerStatsDTO getPlayerStatsByTeam(String teamName);
}
