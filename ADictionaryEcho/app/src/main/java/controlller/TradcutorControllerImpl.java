package controlller;

import model.DiccionarioModel;
import view.VistaDiccionario;

/**
 * Created by tomas on 11/4/2018.
 */

public class TradcutorControllerImpl implements TraductorController {

    protected DiccionarioModel model;
    protected VistaDiccionario vista;

    public TradcutorControllerImpl(DiccionarioModel model, VistaDiccionario vista) {
        this.model = model;
        this.vista = vista;
    }

    @Override
    public void onEventUpdate(String textoATraducir) {
        String sig = model.retornarSignificado(textoATraducir);
        vista.updateTexto(sig);
    }

    @Override
    public void setEditUserView(VistaDiccionario editUserView) {

    }
}
