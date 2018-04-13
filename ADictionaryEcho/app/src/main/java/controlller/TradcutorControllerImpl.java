package controlller;

import model.DiccionarioModel;
import view.VistaDiccionario;

/**
 * Created by tomas on 11/4/2018.
 */

public class TradcutorControllerImpl implements TraductorController {

    protected DiccionarioModel model;

    public TradcutorControllerImpl(DiccionarioModel model) {
        this.model = model;
    }

    @Override
    public void onEventUpdate(String textToTranslate) {
        model.translateWord(textToTranslate);
    }

}
