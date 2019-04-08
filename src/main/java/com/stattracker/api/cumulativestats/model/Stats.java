package com.stattracker.api.cumulativestats.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class Stats {
    /**
     * As constructed atm, I believe this is wrong.
     * Statistics is an object... but with nested maps. It's not just a map itself.
     * If it's going to be a map itself, it would have to be "stats" is the name of the map that is <String, Stat object>
     */
    private Map<String, Stat> statistics;
}
