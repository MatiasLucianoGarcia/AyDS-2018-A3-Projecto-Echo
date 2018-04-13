package model;

public class ModelModule {

    private static ModelModule instance;
    private DiccionarioModel dicModel;

    private ModelModule() {
        dicModel =  new DiccionarioModelConcreta();
    }

    public static ModelModule getInstance() {
        if(instance == null) {
            instance =  new ModelModule();
        }
        return instance;
    }

    public DiccionarioModel getDiccionarioModel() {
        return dicModel;
    }
}
