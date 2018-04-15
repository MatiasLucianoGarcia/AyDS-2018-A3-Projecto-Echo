package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ayds.dictionary.echo.R;
import controller.TranslatorController;
import model.ConverterToHTML;
import model.FormatConverter;
import model.TranslatorModel;
import model.ModelModule;
import model.TranslatorModelListener;
import controller.ControllerModule;

public class TranslatorViewImpl extends AppCompatActivity implements TranslatorView {

    private EditText textFieldForTranslatingWord;
    private Button buttonForTranslating;
    private TextView labelTranslatedWord;

    private FormatConverter convertidorFormato;

    private TranslatorController controlador;
    private TranslatorModel modelo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGraphic();
        convertidorFormato = new ConverterToHTML();
        initModules();
        initListener();

    }

    private void initModules(){
        ModelModule.getInstance().initTranslatorModel(getApplicationContext());
        controlador= ControllerModule.getInstance().getTraductorController();
        modelo = ModelModule.getInstance().getTranslatorModel();
    }

    private void initGraphic(){

        setContentView(R.layout.activity_main);
        textFieldForTranslatingWord = findViewById(R.id.textField1);
        buttonForTranslating = findViewById(R.id.goButton);
        labelTranslatedWord = findViewById(R.id.textPane1);

    }

    private void initListener(){
        buttonForTranslating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlador.onEventUpdate(textFieldForTranslatingWord.getText().toString());
            }
        });
        modelo.setListener(new TranslatorModelListener() {
            @Override public void didUpdateWord(String translatedWord) {
                updateTexto(translatedWord);
            }
        });
    }


    @Override
    public void updateTexto(String translatedWord) {
        translatedWord = translatedWord.replace("\\n", "<br>");
      /*  translatedWord = convertidorFormato.formatTo(translatedWord, term);
        final String textToSet = translatedWord;
        textPane1.post(new Runnable() {
            public void run() {
                textPane1.setText(Html.fromHtml(textToSet));
            }
        });*/
        translatedWord = "<b>"+ translatedWord +"</b>";
        final String wordToShow = translatedWord;
        labelTranslatedWord.post(new Runnable() {
            @Override
            public void run() {
                labelTranslatedWord.setText(Html.fromHtml(wordToShow));
            }
        });
    }
}
