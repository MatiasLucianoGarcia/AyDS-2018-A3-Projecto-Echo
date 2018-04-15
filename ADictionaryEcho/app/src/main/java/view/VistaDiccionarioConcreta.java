package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ayds.dictionary.echo.R;
import controller.TranslatorController;
import model.TranslatorModel;
import model.ModelModule;
import model.TranslatorModelListener;
import controller.ControllerModule;

/**
 * Created by tomas on 11/4/2018.
 */

public class VistaDiccionarioConcreta extends AppCompatActivity implements VistaDiccionario {

    private EditText textFieldIngresoPalabra;
    private Button botonTraductor;
    private TextView etiquetaTextoTraducido;

    private TranslatorController controlador;
    private TranslatorModel modelo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGraphic();
        initModules();
        initListener();

    }

    private void initModules(){
        controlador= ControllerModule.getInstance().getTraductorController();
        modelo = ModelModule.getInstance().getDiccionarioModel();
    }

    private void initGraphic(){

        setContentView(R.layout.activity_main);
        textFieldIngresoPalabra = findViewById(R.id.textField1);
        botonTraductor = findViewById(R.id.goButton);
        etiquetaTextoTraducido = findViewById(R.id.textPane1);

    }

    private void initListener(){
        botonTraductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlador.onEventUpdate(textFieldIngresoPalabra.getText().toString());
            }
        });
        modelo.setListener(new TranslatorModelListener() {
            @Override public void didUpdateWord() {
                updateTexto();
            }
        });
    }


    @Override
    public void updateTexto() {
        etiquetaTextoTraducido.setText(modelo.getWord());
    }
}
