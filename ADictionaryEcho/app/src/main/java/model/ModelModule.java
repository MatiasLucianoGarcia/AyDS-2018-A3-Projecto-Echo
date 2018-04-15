package model;

import android.arch.persistence.room.Database;

import com.google.gson.Gson;

import model.service.TranslatorServiceImpl;
import model.service.YandexApiConnection;

public class ModelModule {

    private static ModelModule instance;
    private TranslatorModel dicModel;

    private ModelModule() {
        dicModel =  new TranslatorModelConcrete2(new TranslatorServiceImpl(new YandexApiConnection().getYandex(),new Gson()), DataBase.getInstance());
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
