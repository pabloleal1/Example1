package com.atsistemas.appium;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JsonParseData {

    private static final String JSONPATH = "./src/test/resources/jsonData.json";

    private JsonParseData() {
        throw new IllegalStateException("Utility class");
    }

    public static String get(String obj, String element) throws Exception {

        JsonParser parser = new JsonParser();
        BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(JSONPATH), StandardCharsets.UTF_8));
        JsonObject gsonObj = parser.parse(bis).getAsJsonObject();

        JsonObject gsonObjInt = gsonObj.get(obj).getAsJsonObject();
        return gsonObjInt.get(element).getAsString();

    }

}