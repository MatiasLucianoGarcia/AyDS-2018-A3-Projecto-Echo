package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.business.services.ServiceAdministrator;
import ayds.dictionary.echo.model.business.services.ServiceDefinition;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

import java.util.ArrayList;
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
        List<TranslationConcept> translationConcepts = initTranslationConcepts();
        try{
            checkWellFormedSentence(wordToTranslate);
            translationConcepts = iterateServices(translationConcepts,wordToTranslate);
        }
        catch(NonTranslatableWordException e)
        {
            exceptionHandler.handleException(e);
        }
        return translationConcepts;
    }

    private List<TranslationConcept> iterateServices(List<TranslationConcept> translationConcepts, String wordToTranslate){
            int i = 0;
            for (Map.Entry<Source,ServiceDefinition> entry : serviceAdministrator.getServices().entrySet()) {
                try{
                    TranslationConcept translationConcept = storage.getMeaning(wordToTranslate,entry.getKey());
                    if (!translationConcept.getMeaning().equals("")) {
                        translationConcept.setMeaning("[*]" + translationConcept.getMeaning());
                    }
                    else{
                        String translatedWord = findMeaningInService(wordToTranslate,entry.getValue());
                        translationConcept =  new TranslationConcept(wordToTranslate,translatedWord, entry.getKey());
                        storage.saveTerm(translationConcept);
                    }
                    translationConcepts.remove(i);
                    translationConcepts.add(i,translationConcept);
                }
                catch (Exception exception){
                    exceptionHandler.handleException(exception);
                }
                i++;
            }
        return translationConcepts;
    }

    private List<TranslationConcept> initTranslationConcepts(){
        List<TranslationConcept> translationConcepts = new ArrayList<>();
        for(int i=0;i<serviceAdministrator.getServices().size();i++){
            translationConcepts.add(i, new NullTranslationConcept());
        }
        return translationConcepts;
    }

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isCorrect(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }

    private String findMeaningInService(String wordToTranslate, ServiceDefinition serviceDefinition) throws Exception{
        String translatedWord = serviceDefinition.getResult(wordToTranslate);
        if(translatedWord == null)
            translatedWord = "";
        return translatedWord;
    }

    @Override
    public void setExceptionListener(TranslatorModelExceptionListener exceptionListener) {
        exceptionHandler.setListener(exceptionListener);
    }

}
