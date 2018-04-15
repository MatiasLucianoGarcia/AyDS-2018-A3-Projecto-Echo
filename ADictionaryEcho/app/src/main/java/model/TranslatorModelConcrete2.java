package model;

import model.service.TranslatorService;


public class TranslatorModelConcrete2 implements TranslatorModel {

    private TranslatorModelListener listener;
    private TranslatorService translatorService;
    private StorageInterface externalStorage;

    public TranslatorModelConcrete2(TranslatorService service, StorageInterface externalStorage) {
        this.externalStorage = externalStorage;
        this.translatorService = service;
    }

    public void translateWord(String wordToTranslate) {
        String translatedWord = externalStorage.getMeaning(wordToTranslate);

        if (translatedWord != null) {
            translatedWord = "[*]" + translatedWord;
        }
        else {
            translatedWord = findTranslationOnline(wordToTranslate);
            externalStorage.saveTerm(wordToTranslate, translatedWord);
        }

        listener.didUpdateWord(translatedWord);
    }

    private String findTranslationOnline(String term) {
        return translatorService.callCreateTranslatedWord(term);
    }

    @Override
    public void setListener(TranslatorModelListener listener) {
        this.listener = listener;
    }
}
