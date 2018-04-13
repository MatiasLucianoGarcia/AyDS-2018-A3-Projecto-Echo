package controller;

import model.TranslatorModel;

/**
 * Created by tomas on 11/4/2018.
 */

public class TranslatorControllerImpl implements TranslatorController {

    protected TranslatorModel model;

    public TranslatorControllerImpl(TranslatorModel model) {
        this.model = model;
    }

    @Override
    public void onEventUpdate(String textToTranslate) {
        model.translateWord(textToTranslate);
    }

}
