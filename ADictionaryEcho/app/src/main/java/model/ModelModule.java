package model;

import com.google.gson.Gson;

import model.service.TranslatorServiceImpl;
import model.service.YandexAPI;
import model.service.YandexApiConnection;

public class ModelModule {

    private static ModelModule instance;
    private TranslatorModel dicModel;
    private YandexApiConnection apiConnection;

    private ModelModule() {
        apiConnection = new YandexApiConnection();
        apiConnection.conectarAPI();
        dicModel =  new TranslatorModelConcrete(new TranslatorServiceImpl(apiConnection.getYandex(),new Gson()), DataBase.getInstance());
    }

    public static ModelModule getInstance() {
        if(instance == null) {
            instance =  new ModelModule();
        }
        return instance;
    }

    public TranslatorModel getDiccionarioModel() {
        return dicModel;
    }
}
