package com.stattracker.cumulativestats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stattracker.cumulativestats.model.CumulativePlayerStats;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativePlayerStatsDTO {
    private String lastUpdatedOn;
    @JsonProperty("playerstatsentry")
    private PlayerStatsEntryDTO playerStatsEntry;

    public static CumulativePlayerStatsDTO fromCumulativePlayerStats(CumulativePlayerStats cumulativePlayerStats) {
        CumulativePlayerStatsDTO cumulativePlayerStatsDTO = new CumulativePlayerStatsDTO();

        cumulativePlayerStatsDTO.setLastUpdatedOn(cumulativePlayerStats.getLastUpdatedOn());
        cumulativePlayerStatsDTO.setPlayerStatsEntry(PlayerStatsEntryDTO.fromPlayerStatsEntry(cumulativePlayerStats.getPlayerStatsEntry()));

        return cumulativePlayerStatsDTO;
    }
}
