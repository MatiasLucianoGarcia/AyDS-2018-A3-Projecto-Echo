package ayds.dictionary.echo.model.services;

import java.io.IOException;

import ayds.dictionary.charlie.service.BighugelabsService;
import ayds.dictionary.echo.model.business.SpellingChecker;
import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

class ServiceBigHugLabsAdapter implements ServiceDefinition {

    private BighugelabsService bighugelabsService;

    ServiceBigHugLabsAdapter (BighugelabsService bighugelabsService){
        this.bighugelabsService=bighugelabsService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        String result = "";
        try{
            checkWellFormedSentence(wordToGetResult);
            result = bighugelabsService.searchWord(wordToGetResult);
        }
        catch (IOException exception){
            throw new ModelNoConnectionException();
        }
        return result;
    }

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isOnlyOneWord(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }

}
