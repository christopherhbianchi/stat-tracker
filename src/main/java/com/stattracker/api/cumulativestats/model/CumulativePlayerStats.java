package com.stattracker.api.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativePlayerStats {
    private String lastUpdatedOn;
    @JsonProperty("playerstatsentry")
    private List<PlayerStatsEntry> playerStatsEntryList;
}
