package model.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Response;

public class TranslatorServiceImpl implements TranslatorService {
    private Gson gson;
    private YandexAPI service;

    public TranslatorServiceImpl(YandexAPI service, Gson gson) {
        this.service = service;
        this.gson = gson;
    }

    public String callCreateUserService(String word) {
        Response<String> callResponse=null;
        try {
            callResponse = service.getTerm(word).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = callResponse.body();
        return createTranslatorResult(json);
    }

    //TODO Mandar codigo a otra clase
    private String createTranslatorResult(String json) {
        JsonObject result = null;
        if (json != null) {

            result = gson.fromJson(json, JsonObject.class);
        }
        return result.get("text").getAsString();
    }
}
