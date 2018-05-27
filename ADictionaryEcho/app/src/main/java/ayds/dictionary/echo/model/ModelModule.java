package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.business.BusinessModule;

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
        translatorModel = new TranslatorModelImpl(BusinessModule.getInstance().getRepository());
    }

    public TranslatorModel getTranslatorModel() {
        return translatorModel;
    }
}
