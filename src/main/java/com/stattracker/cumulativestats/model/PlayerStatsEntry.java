package com.stattracker.cumulativestats.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class PlayerStatsEntry {
    private Player player;
    private Team team;
    private Stats stats;
}
