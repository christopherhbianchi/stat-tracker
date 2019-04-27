package com.stattracker.api.sportscraper.internal;

import com.google.gson.JsonParseException;
import com.stattracker.api.sportscraper.SportScraperService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This service will scrape ESPN's NBA teams page to retrieve team name and division data.
 * @author Christopher Bianchi
 **/
@Service
@Slf4j
public class SportScraperServiceImpl implements SportScraperService {


    @Override
    public List<String> getTeams() {
        Elements elementsByClass = Objects.requireNonNull(getEspnDocument()).select("h2.clr-gray-01.di.h5"); //Objects.requireNonNull prevents from having an exception from null pointer
        return elementsByClass.stream().map(Element::text).collect(Collectors.toList());
    }

    /**
     * The mt7 classes have 2 children: 1 with divisionName, and other section element has list of team names.
     * So we want to grab the 1st child element that has the text of divisionName, grab the next sibling element (the section element),
     * select only elements with the classname matching what is on team name elements, stream, grab the text, map it, collect, return
     *
     * @param String divisionName
     * @return List<String>
     */
    @Override
    public List<String> getTeamsByDivisionName(String divisionName) {

        Element sectionElement = Objects.requireNonNull(getEspnDocument()).select("div.headline.pb4.n8.fw-heavy.clr-gray-01")
                .stream()
                .filter(element -> element.text().contains(divisionName))
                .findFirst()
                .orElseThrow(() -> new JsonParseException("Division does not exist"))
                .nextElementSibling();

        return sectionElement.select("h2.clr-gray-01.di.h5").stream()
                .map(Element::text).collect(Collectors.toList());

    }

    private Document getEspnDocument() {
        try {
            return Jsoup.connect("http://www.espn.com/nba/teams").get();
        } catch (IOException e) {
            log.error("Error occurred while retrieving ESPN document.");
            return null;
        }
    }
}

