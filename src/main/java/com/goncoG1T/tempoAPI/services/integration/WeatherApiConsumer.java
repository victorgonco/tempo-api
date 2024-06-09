package com.goncoG1T.tempoAPI.services.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_CONTENT_TYPE;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_ELEMENTS;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_KEY;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_TIME_FIELDS;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_REQUEST_PARAMS_UNIT;
import static com.goncoG1T.tempoAPI.constants.WeatherAPIParameterConstants.URI_STRUCTURE_CONNECTOR;

@Service
public class WeatherApiConsumer {

    @Value("${weather.api.scheme}")
    private static String SCHEME;
    @Value("${weather.api.domain}")
    private static String DOMAIN;
    @Value("${weather.api.path}")
    private static String PATH;
    @Value("${weather.api.key}")
    private static String KEY;

    public String getTempo(String city) {

        var uri = mountURI(city);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .method(RequestMethod.GET.name(),
                        HttpRequest.BodyPublishers.noBody())
                .build();

        try (var client = HttpClient.newHttpClient()) {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            var eClazz = e.getClass();
            System.out.println(eClazz.getName());
            throw new RuntimeException(e);
        }
    }

    private URI mountURI(String city) {

        var sb = new StringBuilder();

        //Mounting host
        sb.append(SCHEME).append(DOMAIN).append(PATH);

        //Pointing city, fixed to São Paulo.
        sb.append(URLEncoder.encode(city, StandardCharsets.UTF_8));

        //Preparing token
        var preparingToken = String.format(KEY, URI_REQUEST_PARAMS_KEY);
        appendParameter(sb, preparingToken);

        //Parameterizing content
        appendParameter(sb, URI_REQUEST_PARAMS_UNIT);
        appendParameter(sb, URI_REQUEST_PARAMS_CONTENT_TYPE);
        appendParameter(sb, URI_REQUEST_PARAMS_ELEMENTS);
        sb.append(URI_REQUEST_PARAMS_TIME_FIELDS);

        return URI.create(sb.toString());

    }
    private void appendParameter(StringBuilder sb, String value) {
        sb.append(value).append(URI_STRUCTURE_CONNECTOR);
    }

}
