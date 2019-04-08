package com.stattracker.api.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class Team {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Abbreviation")
    private String abbreviation;
}
