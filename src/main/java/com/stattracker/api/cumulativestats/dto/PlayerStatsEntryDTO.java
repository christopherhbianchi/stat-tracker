package com.stattracker.api.cumulativestats.dto;

import com.stattracker.api.cumulativestats.model.PlayerStatsEntry;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class PlayerStatsEntryDTO {

    private PlayerDTO playerDTO;
    private TeamDTO teamDTO;
    private Map<String, StatDTO> statDTOs;

    private static PlayerStatsEntryDTO fromPlayerStatsEntry(PlayerStatsEntry playerStatsEntry) {

        PlayerStatsEntryDTO playerStatsEntryDTO = new PlayerStatsEntryDTO();
        if (playerStatsEntry.getPlayer() != null) {
            playerStatsEntryDTO.setPlayerDTO(PlayerDTO.fromPlayer(playerStatsEntry.getPlayer()));
        }
        if (playerStatsEntry.getTeam() != null) {
            playerStatsEntryDTO.setTeamDTO(TeamDTO.fromTeam(playerStatsEntry.getTeam()));
        }
        if (playerStatsEntry.getStats() != null) {

            Map<String, StatDTO> statDTOs = playerStatsEntry.getStats().entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> StatDTO.fromStat(entry.getValue())));

            playerStatsEntryDTO.setStatDTOs(statDTOs);


        }

        return playerStatsEntryDTO;
    }

    public static List<PlayerStatsEntryDTO> fromPlayerStatsEntryList(List<PlayerStatsEntry> playerStatsEntryList) {
        return playerStatsEntryList.stream()
                .map(PlayerStatsEntryDTO::fromPlayerStatsEntry)
                .collect(Collectors.toList());
    }

}
