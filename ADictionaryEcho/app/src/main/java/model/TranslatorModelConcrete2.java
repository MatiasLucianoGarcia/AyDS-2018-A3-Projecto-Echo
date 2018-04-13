package model;

import android.text.Html;

import com.google.gson.Gson;

import model.service.YandexApiConnection;
import model.service.TranslatorService;
import model.service.TranslatorServiceImpl;

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
        //TODO Dependencias en el modulo
        translatorService = new TranslatorServiceImpl(new YandexApiConnection().getYandex(),new Gson());
        String extract = translatorService.callCreateUserService(term);
        //TODO Codigo de la vista
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
