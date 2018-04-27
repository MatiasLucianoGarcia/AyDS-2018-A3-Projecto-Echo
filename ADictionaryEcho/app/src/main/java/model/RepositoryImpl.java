package model;

import model.exceptions.TranslatingWordException;
import model.service.TranslatorService;
import model.storage.Storage;

public class RepositoryImpl implements Repository {

    private Storage storage;
    private TranslatorService translatorService;

    RepositoryImpl(Storage storage,TranslatorService translatorService){
        this.storage = storage;
        this.translatorService = translatorService;
    }

    public String translateWord(String wordToTranslate) throws TranslatingWordException {
        String translatedWord = storage.getMeaning(wordToTranslate);

        if (translatedWord != null) {
            translatedWord = "[*]" + translatedWord;
        }
        else {
            translatedWord = translatorService.callCreateTranslatedWord(wordToTranslate);
            storage.saveTerm(wordToTranslate, translatedWord);
        }

        return translatedWord;
    }

}
