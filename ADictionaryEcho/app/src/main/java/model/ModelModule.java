package model;

import android.content.Context;

import com.google.gson.Gson;

import model.service.TranslatorServiceImpl;
import model.service.YandexApiConnection;

public class ModelModule {

    private static ModelModule instance;

    private ModelModule() {

    }

    public static ModelModule getInstance() {
        if(instance == null) {
            instance =  new ModelModule();
        }
        return instance;
    }

    public TranslatorModel getDiccionarioModel(Context context) {
        DataBase database = DataBase.getInstance();
        database.createNewDatabase(context);
        YandexApiConnection apiConnection = new YandexApiConnection();
        apiConnection.conectarAPI();
        return new TranslatorModelConcrete(new TranslatorServiceImpl(apiConnection.getYandex(),new Gson()), database);
    }
}
