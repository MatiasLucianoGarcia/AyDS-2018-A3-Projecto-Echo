package controller;

import model.TranslatorModel;

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
