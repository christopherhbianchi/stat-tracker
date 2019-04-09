package com.stattracker.app.config;

import com.stattracker.api.common.StatTrackerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Christopher Bianchi
 **/
@Configuration
@EnableSwagger2
public class StatTrackerApplicationConfig {

    @Value("${application.authorization}")
    String authorization;

    @Bean
    public WebClient webClient() {

        Map<String, String> headers = new HashMap<>();

        String authorizationEncoding = Base64.getEncoder().encodeToString(authorization.getBytes());
        headers.put(HttpHeaders.AUTHORIZATION, String.format(StatTrackerConstants.STRING_FORMATTER_TWO, StatTrackerConstants.BASIC, authorizationEncoding));

        return WebClient.builder().defaultHeaders(httpHeaders -> httpHeaders.setAll(headers))
                .build();
    }
}
