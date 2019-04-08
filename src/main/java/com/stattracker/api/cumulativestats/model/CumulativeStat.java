package com.stattracker.api.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativeStat {
    @JsonProperty("cumulativeplayerstats")
    private CumulativePlayerStats cumulativePlayerStats;
}
