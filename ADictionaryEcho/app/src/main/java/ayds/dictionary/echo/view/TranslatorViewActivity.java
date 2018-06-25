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

import java.util.List;

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
    private Button buttonForTranslating;
    private TextView labelWordSource1;
    private TextView labelTranslatedWord1;
    private TextView labelWordSource2;
    private TextView labelTranslatedWord2;
    private TextView labelWordSource3;
    private TextView labelTranslatedWord3;
    private TextView [] textViews;
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
        progressBar = findViewById(R.id.progressBar);
        labelWordSource1 = findViewById(R.id.textViewSource1);
        labelTranslatedWord1 = findViewById(R.id.textViewMeaning1);
        labelWordSource2 = findViewById(R.id.textViewSource2);
        labelTranslatedWord2 = findViewById(R.id.textViewMeaning2);
        labelWordSource3 = findViewById(R.id.textViewSource3);
        labelTranslatedWord3 = findViewById(R.id.textViewMeaning3);
        textViews[0] = labelWordSource1;
        textViews[1] = labelTranslatedWord1;
        textViews[2] = labelWordSource2;
        textViews[3] = labelTranslatedWord2;
        textViews[4] = labelWordSource3;
        textViews[5] = labelTranslatedWord3;
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
            @Override public void didUpdateWord(List<TranslationConcept> translatedWords) {
                updateTextFields(translatedWords);
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

    private void updateTextFields(final List<TranslationConcept> translatedWord) {
        int i = 0;
        for (final TranslationConcept translationConcept : translatedWord) {
            final String wordToShow = formatConverter.formatTo(translationConcept.getMeaning(), translationConcept.getTerm());
            final TextView textView1 = textViews[i+1];
            final TextView textView2 = textViews[i];
            textViews[i+1].post(new Runnable() {
                @Override
                public void run() {
                    textView1.setText(Html.fromHtml(wordToShow));
                    textView2.setText(translationConcept.getSource().getName());
                    progressBar.setVisibility(View.GONE);
                }
            });
            i+=2;
        }
    }

    private void createNewAlertDialog(String exceptionMessage) {
        Toast.makeText(TranslatorViewActivity.this, exceptionMessage,
                Toast.LENGTH_LONG).show();
    }

}
