package com.stattracker.api.sportscraper;

import java.util.List;

/**
 * @author Christopher Bianchi
 **/
public interface SportScraperService {
    List<String> getTeams();

    List<String> getTeamsByDivisionName(String divisionName);
}
