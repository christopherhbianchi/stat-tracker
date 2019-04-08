package com.stattracker.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class Stat {
    @JsonProperty("@category")
    private String category;
    @JsonProperty("@abbreviation")
    private String abbreviation;
    @JsonProperty("#text")
    private String text;
}
