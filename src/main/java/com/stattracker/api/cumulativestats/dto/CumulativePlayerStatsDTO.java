package com.stattracker.api.cumulativestats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stattracker.api.cumulativestats.model.CumulativePlayerStats;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativePlayerStatsDTO {
    private String lastUpdatedOn;
    @JsonProperty("playerstatsentry")
    private List<PlayerStatsEntryDTO> playerStatsEntryDTOs;

    public static CumulativePlayerStatsDTO fromCumulativePlayerStats(CumulativePlayerStats cumulativePlayerStats) {
        CumulativePlayerStatsDTO cumulativePlayerStatsDTO = new CumulativePlayerStatsDTO();

        cumulativePlayerStatsDTO.setLastUpdatedOn(cumulativePlayerStats.getLastUpdatedOn());
        cumulativePlayerStatsDTO.setPlayerStatsEntryDTOs(PlayerStatsEntryDTO.fromPlayerStatsEntryList(cumulativePlayerStats.getPlayerStatsEntryList()));

        return cumulativePlayerStatsDTO;
    }
}
