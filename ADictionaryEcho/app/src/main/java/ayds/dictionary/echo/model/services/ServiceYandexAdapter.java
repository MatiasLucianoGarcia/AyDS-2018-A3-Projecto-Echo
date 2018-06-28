package ayds.dictionary.echo.model.services;

import com.example.yandex.service.NoConnectionException;
import com.example.yandex.service.TranslatorService;

import ayds.dictionary.echo.model.business.SpellingChecker;
import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

class ServiceYandexAdapter implements ServiceDefinition {

    private TranslatorService translatorService;

    ServiceYandexAdapter(TranslatorService translatorService){
        this.translatorService=translatorService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception{
        String result = "";
        try{
            checkWellFormedSentence(wordToGetResult);
            result = translatorService.callCreateTranslatedWord(wordToGetResult);
        }
        catch(NoConnectionException exception) {
            throw new ModelNoConnectionException();
        }
        return result;
    }

    private void checkWellFormedSentence(String wordToCheck) throws NonTranslatableWordException {
        if(!SpellingChecker.isOnlyAlphabetic(wordToCheck)) {
            throw new NonTranslatableWordException();
        }
    }
}
