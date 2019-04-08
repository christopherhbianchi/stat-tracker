package com.stattracker.api.cumulativestats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stattracker.api.cumulativestats.model.Stat;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Christopher Bianchi
 **/
@Getter
@Setter
public class StatDTO {

    @JsonProperty("@category")
    private String category;
    @JsonProperty("@abbreviation")
    private String abbreviation;
    @JsonProperty("#text")
    private String text;

    public static StatDTO fromStat(Stat stat) {

        StatDTO statDTO = new StatDTO();

        statDTO.setCategory(stat.getCategory());
        statDTO.setAbbreviation(stat.getAbbreviation());
        statDTO.setText(stat.getText());

        return statDTO;
    }
}
