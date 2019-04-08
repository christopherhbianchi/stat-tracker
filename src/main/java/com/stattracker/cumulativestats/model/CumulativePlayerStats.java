package com.stattracker.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativePlayerStats {
    private String lastUpdatedOn;
    @JsonProperty("playerstatsentry")
    private PlayerStatsEntry playerStatsEntry;
}
