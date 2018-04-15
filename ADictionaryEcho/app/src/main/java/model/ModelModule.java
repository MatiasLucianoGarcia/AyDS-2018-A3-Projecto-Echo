package model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import model.service.TranslatorServiceImpl;
import model.service.YandexApiConnection;

public class ModelModule {

    private static ModelModule instance;
    private TranslatorModel translatorModel;
    private Context contexto;

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
                DataBase.getInstance().saveTerm("test", "sarasa");
                Log.e("**", "" + DataBase.getInstance().getMeaning("test"));
                Log.e("**", "" + DataBase.getInstance().getMeaning("nada"));
            }
        }).start();
        YandexApiConnection apiConnection = new YandexApiConnection();
        apiConnection.conectarAPI();
        translatorModel = new TranslatorModelConcrete(new TranslatorServiceImpl(apiConnection.getYandex(),new Gson()), DataBase.getInstance());

    }

    public TranslatorModel getTranslatorModel() {
        return translatorModel;
    }
}
