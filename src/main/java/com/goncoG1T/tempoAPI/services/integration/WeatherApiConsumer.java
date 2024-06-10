package com.goncoG1T.tempoAPI.services.integration;

import com.goncoG1T.tempoAPI.dtos.responses.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_CONTENT_TYPE;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_ELEMENTS;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_KEY;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_TIME_FIELDS;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_UNIT;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_STRUCTURE_CONNECTOR;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_STRUCTURE_QUERY_STRING;

@Service
public class WeatherApiConsumer {

    private final String SCHEME;
    private final String DOMAIN;
    private final String PATH;
    private final String KEY;

    public WeatherApiConsumer(@Value("${weather.api.scheme}")
                              String SCHEME,
                              @Value("${weather.api.domain}")
                              String DOMAIN,
                              @Value("${weather.api.path}")
                              String PATH,
                              @Value("${weather.api.key}")
                              String KEY) {

        this.SCHEME = SCHEME;
        this.DOMAIN = DOMAIN;
        this.PATH = PATH;
        this.KEY = KEY;
    }

    public WeatherResponse getTempoToDto(String city) {
        return new RestTemplateBuilder().build()
                .getForObject(mountURI(city), WeatherResponse.class);
    }

    private URI mountURI(String city) {

        var sb = new StringBuilder();

        //Mounting host
        sb.append(SCHEME).append(DOMAIN).append(PATH);

        //Pointing city, fixed to São Paulo.
        sb.append(URLEncoder.encode(city, StandardCharsets.UTF_8)).append(URI_STRUCTURE_QUERY_STRING);

        //Preparing token
        var concatenatedKey = String.format(URI_REQUEST_PARAMS_KEY, KEY);
        appendParameter(sb, concatenatedKey);

        //Parameterizing content
        appendParameter(sb, URI_REQUEST_PARAMS_UNIT);
        appendParameter(sb, URI_REQUEST_PARAMS_ELEMENTS);
        appendParameter(sb, URI_REQUEST_PARAMS_CONTENT_TYPE);
        sb.append(URI_REQUEST_PARAMS_TIME_FIELDS);

        return URI.create(sb.toString());

    }

    private void appendParameter(StringBuilder sb, String value) {
        sb.append(value).append(URI_STRUCTURE_CONNECTOR);
    }

}
