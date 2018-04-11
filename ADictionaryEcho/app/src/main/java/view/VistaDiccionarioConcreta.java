package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ayds.dictionary.echo.R;

/**
 * Created by tomas on 11/4/2018.
 */

public class VistaDiccionarioConcreta extends AppCompatActivity implements VistaDiccionario {

    private EditText textFieldIngresoPalabra;
    private Button botonTraductor;
    private TextView etiquetaTextoTraducido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textFieldIngresoPalabra = findViewById(R.id.textField1);
        botonTraductor = findViewById(R.id.goButton);
        etiquetaTextoTraducido = findViewById(R.id.textPane1);
    }

    private void initListener(){
        botonTraductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
