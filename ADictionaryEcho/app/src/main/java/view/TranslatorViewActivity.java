package view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import model.TranslatorModelExceptionListener;
import model.TranslatorModelListener;
import controller.ControllerModule;

public class TranslatorViewActivity extends AppCompatActivity {

    private EditText textFieldForTranslatingWord;
    private Button buttonForTranslating;
    private TextView labelTranslatedWord;

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
    }

    private void saveContext(){
        ViewModule.getInstance().setApplicationContext(getApplicationContext());
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
        model.setExceptionListener(new TranslatorModelExceptionListener() {
            @Override
            public void sendExceptionMessage(String exceptionMessage) {
                createNewAlertDialog(exceptionMessage);
            }
        });
    }

    private void createNewAlertDialog(String exceptionMessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(TranslatorViewActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(exceptionMessage);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
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
