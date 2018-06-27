package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.business.services.ServiceAdministrator;
import ayds.dictionary.echo.model.business.services.Source;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

import java.util.ArrayList;
import java.util.HashMap;
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
        List<TranslationConcept> translationConcepts = new ArrayList<>();
        try{
            checkWellFormedSentence(wordToTranslate);
            translationConcepts = iterateServices(translationConcepts,wordToTranslate);
        }
        catch(NonTranslatableWordException e) {
            exceptionHandler.handleException(e);
        }
        return translationConcepts;
    }

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isCorrect(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }

    private List<TranslationConcept> iterateServices(List<TranslationConcept> translationConcepts, String wordToTranslate){
        Map<Source,Exception> exceptions = new HashMap<>();
            for(Source source : serviceAdministrator.getServices()){
                try{
                    TranslationConcept translationConcept = storage.getMeaning(wordToTranslate,source);
                    if (!translationConcept.getMeaning().equals("")) {
                        translationConcept.setMeaning("[*]" + translationConcept.getMeaning());
                    }
                    else{
                        String translatedWord = serviceAdministrator.getMeaningBySource(source,wordToTranslate);
                        translationConcept =  new TranslationConcept(wordToTranslate,translatedWord, source);
                        storage.saveTerm(translationConcept);
                    }
                    translationConcepts.add(translationConcept);
                }
                catch (Exception exception){
                    exceptions.put(source,exception);
                }
            }
        if(!exceptions.isEmpty())
            exceptionHandler.handleExceptions(exceptions);
        return translationConcepts;
    }

    @Override
    public void setExceptionListener(TranslatorModelExceptionListener exceptionListener) {
        exceptionHandler.setListener(exceptionListener);
    }

}
