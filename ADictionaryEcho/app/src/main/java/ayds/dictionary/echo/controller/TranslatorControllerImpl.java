package ayds.dictionary.echo.controller;

import ayds.dictionary.echo.model.TranslatorModel;

class TranslatorControllerImpl implements TranslatorController {

    protected TranslatorModel model;

    TranslatorControllerImpl(TranslatorModel model) {
        this.model = model;
    }

    @Override public void onEventUpdate(String textToTranslate) {
        model.translateWord(textToTranslate);
    }
}
