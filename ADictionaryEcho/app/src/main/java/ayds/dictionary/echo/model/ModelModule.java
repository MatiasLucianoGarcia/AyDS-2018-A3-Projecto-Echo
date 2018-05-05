package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.service.ServiceModule;
import ayds.dictionary.echo.model.storage.StorageModule;

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

    public void initTranslatorModel() {
        Repository repository = new RepositoryImpl(StorageModule.getInstance().getDataBase(), ServiceModule.getInstance().getTranslatorService(),new ExceptionHandlerImpl());
        translatorModel = new TranslatorModelImpl(repository);
    }

    public TranslatorModel getTranslatorModel() {
        return translatorModel;
    }
}
