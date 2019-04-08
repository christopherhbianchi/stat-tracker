package com.stattracker.api.cumulativestats.internal;

import com.google.gson.JsonParseException;
import com.stattracker.api.cumulativestats.CumulativeStatsService;
import com.stattracker.api.cumulativestats.dto.CumulativePlayerStatsDTO;
import com.stattracker.api.cumulativestats.model.CumulativePlayerStats;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Christopher Bianchi
 **/
@Service
public class CumulativeStatsServiceImpl implements CumulativeStatsService {

    private final WebClient webClient;
    private final String playersByCategoryUrl;
    @Value("${application.authorization}")
    String authorization;

    public CumulativeStatsServiceImpl(WebClient webClient,
                                      @Value("${cumulativeStats.playersByCategory}") String playersByCategoryUrl) {
        this.playersByCategoryUrl = playersByCategoryUrl;
        this.webClient = webClient;
    }

    @Override
    public CumulativePlayerStatsDTO getPlayerStatsByCategoryAndLimit(String category, String limit) {

        Map<String, String> params = new HashMap<>();
        params.put("limit", limit);
        params.put("category", String.format("stats.%s.D", category)); // category would be "3PM" so we now need to create the proper String with String.format

        Optional<CumulativePlayerStats> cumulativePlayerStatsOptional = webClient.get()
                .uri(playersByCategoryUrl, params)
                .retrieve()
                .bodyToMono(CumulativePlayerStats.class)
                .blockOptional();

        return cumulativePlayerStatsOptional.map(cumulativePlayerStats -> CumulativePlayerStatsDTO.fromCumulativePlayerStats(cumulativePlayerStats))
                .orElseThrow(() -> new JsonParseException("Could not read cumulative player stats"));
    }

    @Override
    public CumulativePlayerStatsDTO getPlayerStatsByTeam(String teamName) {

        return null;
    }
}
