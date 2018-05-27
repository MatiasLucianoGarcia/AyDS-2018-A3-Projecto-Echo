package com.example.yandex.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

class JsonToStringConverter implements ResultConverter {

    private Gson gson;

    JsonToStringConverter(Gson gson){
        this.gson=gson;
    }

    public String createTranslatorResult(String resultString){
        JsonObject result = null;
        if (resultString != null) {
            result = gson.fromJson(resultString, JsonObject.class);
        }
        return result.get("text").getAsString();
    }
}
