package com.stattracker.api.cumulativestats.internal;

import com.google.gson.JsonParseException;
import com.stattracker.api.common.StatTrackerConstants;
import com.stattracker.api.cumulativestats.CumulativeStatsService;
import com.stattracker.api.cumulativestats.dto.CumulativeStatDTO;
import com.stattracker.api.cumulativestats.model.CumulativeStat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Christopher Bianchi
 **/
@Service
public class CumulativeStatsServiceImpl implements CumulativeStatsService {

    @Value("${application.authorization}")
    private String authorization;
    private final WebClient webClient;
    private final String playersByCategoryUrl;
    private final String statsByTeamUrl;

    public CumulativeStatsServiceImpl(WebClient webClient,
                                      @Value("${cumulativeStats.api.playersByCategory}") String playersByCategoryUrl,
                                      @Value("${cumulativeStats.api.statsByTeam}") String statsByTeamUrl) {
        this.webClient = webClient;
        this.playersByCategoryUrl = playersByCategoryUrl;
        this.statsByTeamUrl = statsByTeamUrl;
    }


    @Override
    public CumulativeStatDTO getPlayerStatsByCategoryAndLimit(String category, String limit) {

        Map<String, String> params = new HashMap<>(); // TODO: account for the encoding of the "%" being "%25" when the FE makes the request to BE
        params.put(StatTrackerConstants.LIMIT, limit);
        params.put(StatTrackerConstants.CATEGORY, String.format(StatTrackerConstants.STATS_BY_CATEGORY_FORMATTER, category));

        Optional<CumulativeStat> cumulativeStatOptional = webClient.get()
                .uri(playersByCategoryUrl, params)
                .retrieve()
                .bodyToMono(CumulativeStat.class)
                .blockOptional();

        return cumulativeStatOptional.map(CumulativeStatDTO::fromCumulativeStat)
                .orElseThrow(() -> new JsonParseException("Could not read cumulative player stats"));
    }

    @Override
    public CumulativeStatDTO getPlayerStatsByTeamName(String teamName) {

        Optional<CumulativeStat> cumulativeStatOptional = webClient.get()
                .uri(statsByTeamUrl, Collections.singletonMap(StatTrackerConstants.TEAM_NAME, teamName))
                .retrieve()
                .bodyToMono(CumulativeStat.class)
                .blockOptional();

        return cumulativeStatOptional.map(CumulativeStatDTO::fromCumulativeStat)
                .orElseThrow(() -> new JsonParseException("Could not read team's cumulative player stats"));
    }
}
