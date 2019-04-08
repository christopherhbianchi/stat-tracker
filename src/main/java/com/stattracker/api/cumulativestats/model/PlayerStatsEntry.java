package com.stattracker.api.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
@JsonIgnoreProperties
public class PlayerStatsEntry {
    private Player player;
    private Team team;
    private Map<String, Stat> stats;
}
