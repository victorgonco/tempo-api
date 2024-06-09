package com.goncoG1T.tempoAPI.constants;

public final class WeatherAPIParameterConstants {

    private WeatherAPIParameterConstants() {
        //This class should have only one instance.
    }

    public static final String URI_REQUEST_PARAMS_KEY = "key=%s";
    public static final String URI_REQUEST_PARAMS_ELEMENTS = "elements=datetime%2Caddress%2Ctempmax%2Ctempmin%2Ctemp%2Cfeelslike%2Chumidity%2Cprecipprob%2Cwindspeed%2Cdescription";
    public static final String URI_REQUEST_PARAMS_CONTENT_TYPE = "contentType=json";
    public static final String URI_REQUEST_PARAMS_TIME_FIELDS = "include=days%2Cobs%2Cremote%2Cfcst";
    public static final String URI_REQUEST_PARAMS_UNIT = "unitGroup=metric";

    public static final String URI_STRUCTURE_CONNECTOR = "&";
    public static final String URI_STRUCTURE_QUERY_STRING = "?";

}
