package com.stattracker.api.cumulativestats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stattracker.api.cumulativestats.model.Team;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class TeamDTO {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Abbreviation")
    private String abbreviation;

    public static TeamDTO fromTeam(Team team) {
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId(team.getId());
        teamDTO.setCity(team.getCity());
        teamDTO.setName(team.getName());
        teamDTO.setAbbreviation(team.getAbbreviation());

        return teamDTO;
    }
}
