package model;

public class ModelModule {

    private static ModelModule instance;
    private TranslatorModel dicModel;

    private ModelModule() {
        dicModel =  new TranslatorModelConcrete();
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
