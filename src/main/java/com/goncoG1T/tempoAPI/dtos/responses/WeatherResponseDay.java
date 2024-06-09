package com.goncoG1T.tempoAPI.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDay {

    @JsonProperty("datetime")
    private LocalDate date;
    @JsonProperty("tempmax")
    private String maxTemperature;
    @JsonProperty("tempmin")
    private String minTemperature;
    @JsonProperty("temp")
    private String actualTemperature;
    @JsonProperty("feelslike")
    private String actualTemperatureFeelsLike;
    private String humidity;
    @JsonProperty("precipprob")
    private String precipitationProbability;
    @JsonProperty("windspeed")
    private String windSpeed;
    private String description;

}
