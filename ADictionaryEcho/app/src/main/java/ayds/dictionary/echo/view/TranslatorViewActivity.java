package ayds.dictionary.echo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ayds.dictionary.echo.R;
import ayds.dictionary.echo.controller.TranslatorController;
import ayds.dictionary.echo.model.TranslatorModel;
import ayds.dictionary.echo.model.ModelModule;
import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.TranslatorModelListener;
import ayds.dictionary.echo.controller.ControllerModule;
import ayds.dictionary.echo.model.business.Source;
import ayds.dictionary.echo.model.business.TranslationConcept;

public class TranslatorViewActivity extends AppCompatActivity {

    private EditText textFieldForTranslatingWord;
    private TextView labelWordSource;
    private Button buttonForTranslating;
    private TextView labelTranslatedWord;
    private ProgressBar progressBar;

    private FormatConverter formatConverter;

    private TranslatorController controller;
    private TranslatorModel model;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        saveContext();
        initGraphic();
        initFormatters();
        initModules();
        initListener();
    }

    private void initFormatters() {
        formatConverter = ViewModule.getInstance().getFormatConverter();
    }

    private void initModules(){
        ModelModule.getInstance().initTranslatorModel();
        controller = ControllerModule.getInstance().getTranslatorController();
        model = ModelModule.getInstance().getTranslatorModel();
    }

    private void initGraphic(){
        setContentView(R.layout.activity_main);
        textFieldForTranslatingWord = findViewById(R.id.textField1);
        buttonForTranslating = findViewById(R.id.goButton);
        labelTranslatedWord = findViewById(R.id.textPane1);
        progressBar = findViewById(R.id.progressBar);
        labelWordSource = findViewById(R.id.textPane);
    }

    private void saveContext(){
        ViewModule.getInstance().setApplicationContext(getApplicationContext());
    }

    private void initListener(){
        buttonForTranslating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                controller.onEventUpdate(textFieldForTranslatingWord.getText().toString());
            }
        });
        model.setListener(new TranslatorModelListener() {
            @Override public void didUpdateWord(TranslationConcept translatedWord) {
                updateTextFields(translatedWord);
            }
        });
        model.setExceptionListener(new TranslatorModelExceptionListener() {
            @Override
            public void sendExceptionMessage(final String exceptionMessage) {
                TranslatorViewActivity.this.runOnUiThread(new Runnable()
                {
                    public void run() {
                        createNewAlertDialog(exceptionMessage);
                    }
                });
            }
        });
    }

    private void updateTextFields(final TranslationConcept translatedWord) {
        final String wordToShow = formatConverter.formatTo(translatedWord.getMeaning(), labelTranslatedWord.getText().toString());
        labelTranslatedWord.post(new Runnable() {
            @Override
            public void run() {
                labelTranslatedWord.setText(Html.fromHtml(wordToShow));
                labelWordSource.setText(translatedWord.getSource().getName());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void createNewAlertDialog(String exceptionMessage) {
        Toast.makeText(TranslatorViewActivity.this, exceptionMessage,
                Toast.LENGTH_LONG).show();
    }

}
