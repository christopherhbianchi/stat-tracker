package com.stattracker.api.cumulativestats.internal;

import com.google.gson.JsonParseException;
import com.stattracker.api.cumulativestats.CumulativeStatsService;
import com.stattracker.api.cumulativestats.dto.CumulativeStatDTO;
import com.stattracker.api.cumulativestats.model.CumulativeStat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
    public CumulativeStatDTO getPlayerStatsByCategoryAndLimit(String category, String limit) {

        // TODO: account for the encoding of the "%" being "%25" when the FE makes the request to BE
        Map<String, String> params = new HashMap<>();
        params.put("limit", limit);
        params.put("category", String.format("stats.%s.D", category)); // category would be "3PM" so we now need to create the proper String with String.format

        Optional<CumulativeStat> cumulativeStatOptional = webClient.get()
                .uri(playersByCategoryUrl, params)
                .retrieve()
                .bodyToMono(CumulativeStat.class)
                .blockOptional();

        return cumulativeStatOptional.map(cumulativeStat -> CumulativeStatDTO.fromCumulativeStat(cumulativeStat))
                .orElseThrow(() -> new JsonParseException("Could not read cumulative player stats"));
    }

    @Override
    public CumulativeStatDTO getPlayerStatsByTeam(String teamName) {

        return null;
    }
}
