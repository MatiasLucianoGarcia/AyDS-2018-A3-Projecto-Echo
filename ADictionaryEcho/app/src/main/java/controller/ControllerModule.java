package controller;

import model.ModelModule;

public class ControllerModule {

    private static ControllerModule instance;

    private ControllerModule() {}

    public static ControllerModule getInstance() {
        if (instance == null) {
            instance = new ControllerModule();
        }
        return instance;
    }

    public TranslatorController getTranslatorController() {
        return new TranslatorControllerImpl( ModelModule.getInstance().getTranslatorModel());
    }
}
