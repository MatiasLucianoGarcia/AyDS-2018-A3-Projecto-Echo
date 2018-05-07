package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;
import com.example.yandex.service.TranslatorService;
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
        String translatedWord="";
        try {
            checkWellFormedSentence(wordToTranslate);
            translatedWord = storage.getMeaning(wordToTranslate);
            if (translatedWord != null) {
                translatedWord = "[*]" + translatedWord;
            }
            else{
                translatedWord = translatorService.callCreateTranslatedWord(wordToTranslate);
                TranslationConcept translationConcept =  new TranslationConcept(wordToTranslate,translatedWord,Sources.YANDEX.ordinal())
                storage.saveTerm(wordToTranslate, translatedWord);
            }
        } catch(Exception exception){
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
