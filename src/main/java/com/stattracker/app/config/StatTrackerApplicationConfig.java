package com.stattracker.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Christopher Bianchi
 **/
@Configuration
public class StatTrackerApplicationConfig {

    @Value("${application.authorization}")
    String authorization;

    @Bean
    public WebClient webClient() {


        Map<String, String> headers = new HashMap<>();
        String encoding = Base64.getEncoder().encodeToString(authorization.getBytes());
        headers.put(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        return WebClient.builder().defaultHeaders(httpHeaders -> httpHeaders.setAll(headers))
                .build();
    }
}
