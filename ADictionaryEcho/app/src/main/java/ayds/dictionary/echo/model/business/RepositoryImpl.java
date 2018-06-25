package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.business.services.ServiceAdministrator;
import ayds.dictionary.echo.model.business.services.ServiceDefinition;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

import java.util.List;
import java.util.Map;

import ayds.dictionary.echo.model.storage.Storage;

class RepositoryImpl implements Repository {

    private Storage storage;
    private ServiceAdministrator serviceAdministrator;
    private ExceptionHandler exceptionHandler;

    RepositoryImpl(Storage storage,ServiceAdministrator serviceAdministrator,ExceptionHandler exceptionHandler){
        this.storage = storage;
        this.serviceAdministrator = serviceAdministrator;
        this.exceptionHandler = exceptionHandler;
    }

    public List<TranslationConcept> translateWord(String wordToTranslate) {
        TranslationConcept translationConcept = new NullTranslationConcept();
        try{
            checkWellFormedSentence(wordToTranslate);
            for (Map.Entry<Source,ServiceDefinition> entry : serviceAdministrator.getServices().entrySet())
            {
                translationConcept = storage.getMeaning(wordToTranslate,entry.getKey());
            }
        }
        catch(Exception exception){
            exceptionHandler.handleException(exception);
        }
        try {

            translationConcept = storage.getMeaning(wordToTranslate);
            if (!translationConcept.getMeaning().equals("")) {
                translationConcept.setMeaning("[*]" + translationConcept.getMeaning());
            }
            else{
                String translatedWord = translatorService.callCreateTranslatedWord(wordToTranslate);
                translationConcept =  new TranslationConcept(wordToTranslate,translatedWord, Source.YANDEX);
                storage.saveTerm(translationConcept);
            }
        } catch(Exception exception){
            exceptionHandler.handleException(exception);
        }
        return translationConcept;
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
