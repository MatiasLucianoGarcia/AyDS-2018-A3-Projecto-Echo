package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;
import ayds.dictionary.echo.model.exceptions.TranslatingWordException;
import ayds.dictionary.echo.model.service.TranslatorService;
import ayds.dictionary.echo.model.storage.Storage;

public class RepositoryImpl implements Repository {

    private Storage storage;
    private TranslatorService translatorService;

    RepositoryImpl(Storage storage,TranslatorService translatorService){
        this.storage = storage;
        this.translatorService = translatorService;
    }

    public String translateWord(String wordToTranslate) throws TranslatingWordException {
        checkWellFormedSentence(wordToTranslate);

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

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isCorrect(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }

}
