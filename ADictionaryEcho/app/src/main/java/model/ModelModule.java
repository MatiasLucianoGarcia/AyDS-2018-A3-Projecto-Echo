package model;

import android.content.Context;

import com.google.gson.Gson;

import model.service.JsonToStringConverter;
import model.service.ResultConverter;
import model.service.TranslatorServiceImpl;
import model.service.YandexApiConnection;
import model.storage.DataBase;

public class ModelModule {

    private static ModelModule instance;
    private TranslatorModel translatorModel;

    private ModelModule() {

    }

    public static ModelModule getInstance() {
        if(instance == null) {
            instance =  new ModelModule();
        }
        return instance;
    }

    public void initTranslatorModel(final Context applicationContext){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DataBase.getInstance().createNewDatabase(applicationContext);
            }
        }).start();

        YandexApiConnection apiConnection = new YandexApiConnection();
        apiConnection.connectAPI();

        ResultConverter resultConverter = new JsonToStringConverter(new Gson());

        Repository repository = new RepositoryImpl(DataBase.getInstance(),new TranslatorServiceImpl(apiConnection.getYandex(),resultConverter));
        translatorModel = new TranslatorModelImpl(repository);

    }

    public TranslatorModel getTranslatorModel() {
        return translatorModel;
    }
}
