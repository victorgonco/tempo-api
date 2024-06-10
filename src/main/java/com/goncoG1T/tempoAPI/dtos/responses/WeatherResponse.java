package com.goncoG1T.tempoAPI.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(
        @JsonProperty("resolvedAddress")
        String address,
        String description,
        List<WeatherResponseDay> days) {
}
