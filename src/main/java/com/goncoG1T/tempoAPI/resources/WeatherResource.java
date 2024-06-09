package com.goncoG1T.tempoAPI.resources;

import com.goncoG1T.tempoAPI.services.integration.WeatherApiConsumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/findWeather")
@Controller
@ResponseBody //Annotation added only for test purposes, this will be a web app.
public class WeatherResource {

    private final WeatherApiConsumer weatherApiConsumer;

    public WeatherResource(WeatherApiConsumer weatherApiConsumer) {
        this.weatherApiConsumer = weatherApiConsumer;
    }

    @GetMapping("byCity")
    public String byCity(@RequestParam String city) {
        return weatherApiConsumer.getTempo(city);
    }

}
