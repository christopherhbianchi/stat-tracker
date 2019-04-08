package com.stattracker.cumulativestats.dto;

import com.stattracker.cumulativestats.model.PlayerStatsEntry;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class PlayerStatsEntryDTO {

    private PlayerDTO playerDTO;
    private TeamDTO teamDTO;
    private StatsDTO statsDTO;

    public static PlayerStatsEntryDTO fromPlayerStatsEntry(PlayerStatsEntry playerStatsEntry) {

        PlayerStatsEntryDTO playerStatsEntryDTO = new PlayerStatsEntryDTO();
        playerStatsEntryDTO.setPlayerDTO(PlayerDTO.fromPlayer(playerStatsEntry.getPlayer()));
        playerStatsEntryDTO.setTeamDTO(TeamDTO.fromTeam(playerStatsEntry.getTeam()));
        playerStatsEntryDTO.setStatsDTO(StatsDTO.fromStats(playerStatsEntry.getStats()));

        return playerStatsEntryDTO;
    }
}
