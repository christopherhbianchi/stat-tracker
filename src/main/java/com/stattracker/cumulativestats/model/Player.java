package com.stattracker.cumulativestats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class Player {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("JerseyNumber")
    private String jerseyNumber;
    @JsonProperty("Position")
    private String position;
}
