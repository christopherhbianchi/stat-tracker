package com.stattracker.cumulativestats.internal;

import com.stattracker.cumulativestats.CumulativeStatsService;
import com.stattracker.cumulativestats.dto.CumulativePlayerStatsDTO;
import org.springframework.stereotype.Service;

/**
 * @author Christopher Bianchi
 **/
@Service
public class CumulativeStatsServiceImpl implements CumulativeStatsService {
    @Override
    public CumulativePlayerStatsDTO getPlayerStatsByCategory(String category) {
        return null;
    }

    @Override
    public CumulativePlayerStatsDTO getPlayerStatsByTeam(String teamName) {
        return null;
    }
}
