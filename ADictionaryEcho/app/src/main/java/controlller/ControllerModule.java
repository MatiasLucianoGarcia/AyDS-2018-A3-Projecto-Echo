package controlller;

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

    private TraductorController getEditUserController() {
        return new TradcutorControllerImpl( ModelModule.getInstance().getDiccionarioModel());
    }
}
