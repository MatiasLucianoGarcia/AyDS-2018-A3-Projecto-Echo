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
import model.TranslatorModel;
import model.ModelModule;
import model.TranslatorModelListener;
import controller.ControllerModule;

public class TranslatorViewImpl extends AppCompatActivity {

    private EditText textFieldForTranslatingWord;
    private Button buttonForTranslating;
    private TextView labelTranslatedWord;

    private FormatConverter formatConverter;

    private TranslatorController controller;
    private TranslatorModel model;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGraphic();
        initFromatters();
        initModules();
        initListener();

    }

    private void initFromatters() {
        formatConverter = new ConverterToHTMLBoldHighlighter();
    }

    private void initModules(){
        ModelModule.getInstance().initTranslatorModel(getApplicationContext());
        controller = ControllerModule.getInstance().getTraductorController();
        model = ModelModule.getInstance().getTranslatorModel();
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
                controller.onEventUpdate(textFieldForTranslatingWord.getText().toString());
            }
        });
        model.setListener(new TranslatorModelListener() {
            @Override public void didUpdateWord(String translatedWord) {
                updateText(translatedWord);
            }
        });
    }

    private void updateText(String translatedWord) {
        translatedWord = formatConverter.formatTo(translatedWord, labelTranslatedWord.getText().toString());
        final String wordToShow = translatedWord;
        labelTranslatedWord.post(new Runnable() {
            @Override
            public void run() {
                labelTranslatedWord.setText(Html.fromHtml(wordToShow));
            }
        });
    }
}
