package model;

import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import model.service.ConexionAPIConcretaYandex;
import model.service.TranslatorService;
import model.service.TranslatorServiceImpl;
import retrofit2.Response;

/**
 * Created by tomas on 13/4/2018.
 */

public class TranslatorModelConcrete2 implements TranslatorModel {

    private String translatedWord;
    private TranslatorModelListener listener;
    private TranslatorService translatorService;

    public TranslatorModelConcrete2() {}

    public void translateWord(String term) {
        translatedWord = DataBase.getMeaning(term);

        if (translatedWord != null) {

            translatedWord = "[*]" + translatedWord;
        }
        else {
            findTranslationOnline();
        }

        final String textToSet = translatedWord;
        textPane1.post(new Runnable() {
            public void run() {
                textPane1.setText(Html.fromHtml(textToSet));
            }
        });
    }

    private void findTranslationOnline() {
        translatorService = new TranslatorServiceImpl(new ConexionAPIConcretaYandex().getYandex(),new Gson());
        String extract = translatorService.callCreateUserService(term);
        translatedWord = extract.replace("\\n", "<br>");
        translatedWord = textToHtml(translatedWord, term);

        DataBase.saveTerm(textField1.getText().toString(), translatedWord);
    }


    public String getWord(){
        return translatedWord;
    }

    @Override
    public void setListener(TranslatorModelListener listener) {
        this.listener = listener;
    }
}
