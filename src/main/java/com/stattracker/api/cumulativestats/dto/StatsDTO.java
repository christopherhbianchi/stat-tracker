package com.stattracker.api.cumulativestats.dto;

import com.stattracker.api.cumulativestats.model.Stats;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class StatsDTO {
    private Map<String, StatDTO> statisticDTOs;

    public static StatsDTO fromStats(Stats stats) {

        StatsDTO statsDTO = new StatsDTO();

        /**
         * Iterate through the map and each entry must be converted into a StatDTO
         */
        Map<String, StatDTO> statisticDTOs = stats.getStatistics().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> StatDTO.fromStat(entry.getValue())));;

        statsDTO.setStatisticDTOs(statisticDTOs);
        return statsDTO;
    }
}
