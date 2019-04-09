package com.stattracker.api.cumulativestats;

import com.stattracker.api.cumulativestats.dto.CumulativeStatDTO;

/**
 * Getting the player stats by category will retrieve the top 10 players by a specific category name.
 * Such as 3PM, FGM, FG%, Blocks, Assists, etc.
 *
 * Getting the Player Stats by team will retrieve the list of player stats by a specific team, and the sorting and
 * rearranging will be handled on the FE as user clicks through how they want the list reorganized.
 *
 * @author Christopher Bianchi
 **/
public interface CumulativeStatsService {
    CumulativeStatDTO getPlayerStatsByCategoryAndLimit(String category, String limit);
    CumulativeStatDTO getPlayerStatsByTeamName(String teamName);
}
