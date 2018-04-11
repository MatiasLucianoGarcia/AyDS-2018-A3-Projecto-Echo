package controlller;

import view.VistaDiccionario;

/**
 * Created by tomas on 11/4/2018.
 */

public interface TraductorController {
    void onEventUpdate(String textoATraducir);
    void setEditUserView(VistaDiccionario editUserView);
}
