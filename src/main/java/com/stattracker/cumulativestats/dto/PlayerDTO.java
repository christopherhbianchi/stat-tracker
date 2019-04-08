package com.stattracker.cumulativestats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stattracker.cumulativestats.model.Player;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class PlayerDTO {

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

    public static PlayerDTO fromPlayer(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setId(player.getId());
        playerDTO.setFirstName(player.getFirstName());
        playerDTO.setLastName(player.getLastName());
        playerDTO.setJerseyNumber(player.getJerseyNumber());
        playerDTO.setPosition(player.getPosition());

        return playerDTO;
    }
}
