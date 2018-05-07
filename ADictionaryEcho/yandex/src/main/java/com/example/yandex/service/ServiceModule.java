package com.example.yandex.service;

import com.google.gson.Gson;

public class ServiceModule {

    private static final ServiceModule ourInstance = new ServiceModule();

    private ResultConverter resultConverter;
    private TranslatorService translatorService;
    private YandexApiConnection apiConnection;

    public static ServiceModule getInstance() {
        return ourInstance;
    }

    private ServiceModule() {
        initServices();
    }

    private void initServices(){
        resultConverter = new JsonToStringConverter(new Gson());
        apiConnection = new YandexApiConnection();
        conectarApi();
        translatorService = new TranslatorServiceImpl(apiConnection.getYandex(),resultConverter);
    }

    private void conectarApi(){
        apiConnection.connectAPI();
    }

    public TranslatorService getTranslatorService(){
        return translatorService;
    }
}
