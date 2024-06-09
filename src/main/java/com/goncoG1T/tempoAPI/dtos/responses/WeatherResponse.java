package com.goncoG1T.tempoAPI.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherResponse(
        @JsonProperty("resolvedAddress")
        String address,
        @JsonProperty("description")
        String overallDesc,
        List<WeatherResponseDay> days) {
}
