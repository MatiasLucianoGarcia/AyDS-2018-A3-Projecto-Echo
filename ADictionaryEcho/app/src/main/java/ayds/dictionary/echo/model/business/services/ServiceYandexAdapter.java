package ayds.dictionary.echo.model.business.services;

import com.example.yandex.service.NoConnectionException;
import com.example.yandex.service.TranslatorService;

import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;

class ServiceYandexAdapter implements ServiceDefinition {

    private TranslatorService translatorService;

    ServiceYandexAdapter(TranslatorService translatorService){
        this.translatorService=translatorService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception{
        String result = "";
        try{
            result = translatorService.callCreateTranslatedWord(wordToGetResult);
        }
        catch(NoConnectionException exception) {
            throw new ModelNoConnectionException();
        }
        return result;
    }
}
