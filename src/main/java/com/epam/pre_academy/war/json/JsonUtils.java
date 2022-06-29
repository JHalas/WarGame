package com.epam.pre_academy.war.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @author Jakub Hałas
 */

public final class JsonUtils {
    private static final Gson gson = new Gson();

    public JsonUtils(){};

    public static Boolean isJSONValid(String jsonInString)  {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true ;
        } catch(JsonSyntaxException ex) {
            return false;
        }
    }
}
