package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;
import ayds.dictionary.echo.model.exceptions.TranslatingWordException;
import ayds.dictionary.echo.model.service.TranslatorService;
import ayds.dictionary.echo.model.storage.Storage;

class RepositoryImpl implements Repository {

    private Storage storage;
    private TranslatorService translatorService;
    private ExceptionHandler exceptionHandler;

    RepositoryImpl(Storage storage,TranslatorService translatorService,ExceptionHandler exceptionHandler){
        this.storage = storage;
        this.translatorService = translatorService;
        this.exceptionHandler = exceptionHandler;
    }

    public String translateWord(String wordToTranslate) {
        String translatedWord=null;
        try {
            checkWellFormedSentence(wordToTranslate);
            translatedWord = storage.getMeaning(wordToTranslate);
            if (translatedWord != null) {
                translatedWord = "[*]" + translatedWord;
            }
            else{
                translatedWord = translatorService.callCreateTranslatedWord(wordToTranslate);
                storage.saveTerm(wordToTranslate, translatedWord);
            }
        } catch(TranslatingWordException exception){
            exceptionHandler.handleException(exception);
        }
        return translatedWord;
    }

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isCorrect(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }

    @Override
    public void setExceptionListener(TranslatorModelExceptionListener exceptionListener) {
        exceptionHandler.setListener(exceptionListener);
    }

}
