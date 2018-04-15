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

    public TranslatorModelConcrete2(TranslatorService service) {
        translatorService = service;
    }

    public void translateWord(String term) {
        translatedWord = DataBase.getMeaning(term);

        if (translatedWord != null) {

            translatedWord = "[*]" + translatedWord;
        }
        else {
            findTranslationOnline(term);
        }
    }

    private void findTranslationOnline(String term) {
        String extract = translatorService.callCreateUserService(term);
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
