package model;

import android.content.Context;
import model.service.ServiceModule;
import model.storage.StorageModule;

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

    public void initTranslatorModel(){
        Repository repository = new RepositoryImpl(StorageModule.getInstance().getDataBase(), ServiceModule.getInstance().getTranslatorService());
        translatorModel = new TranslatorModelImpl(repository);
    }

    public TranslatorModel getTranslatorModel() {
        return translatorModel;
    }
}
