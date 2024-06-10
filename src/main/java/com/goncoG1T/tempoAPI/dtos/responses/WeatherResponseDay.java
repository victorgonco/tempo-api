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
    @JsonProperty(value = "feelslike")
    private String actualTemperatureFeelsLike;
    private String humidity;
    @JsonProperty("precipprob")
    private String precipitationProbability;
    @JsonProperty("windspeed")
    private String windSpeed;
    @JsonProperty("description")
    private String overallDesc;

    public WeatherResponseDay(LocalDate date,
                              String maxTemperature,
                              String minTemperature,
                              String actualTemperature,
                              String actualTemperatureFeelsLike,
                              String humidity,
                              String precipitationProbability,
                              String windSpeed,
                              String overallDesc) {
        this.date = date;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.actualTemperature = actualTemperature;
        this.actualTemperatureFeelsLike = actualTemperatureFeelsLike;
        this.humidity = humidity;
        this.precipitationProbability = precipitationProbability;
        this.windSpeed = windSpeed;
        this.overallDesc = overallDesc;
    }

}
