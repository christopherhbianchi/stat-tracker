package com.stattracker.api.cumulativestats.dto;

import com.stattracker.api.cumulativestats.model.CumulativeStat;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class CumulativeStatDTO {
    private CumulativePlayerStatsDTO cumulativePlayerStatsDTO;

    public static CumulativeStatDTO fromCumulativeStat(CumulativeStat cumulativeStat) {
        CumulativeStatDTO cumulativeStatDTO = new CumulativeStatDTO();
        cumulativeStatDTO.setCumulativePlayerStatsDTO(CumulativePlayerStatsDTO.fromCumulativePlayerStats(cumulativeStat.getCumulativePlayerStats()));
        return cumulativeStatDTO;
    }
}
