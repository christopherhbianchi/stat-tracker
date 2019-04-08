package com.stattracker.cumulativestats.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class Stats {
    private Map<String, Stat> statistics;
}
