package ayds.dictionary.echo.model.business.services;

import com.example.yandex.service.ServiceModule;
import com.example.yandex.service.TranslatorService;

public class ServiceYandexAdapter implements ServiceDefinition {

    private TranslatorService translatorService = ServiceModule.getInstance().getTranslatorService();

    @Override
    public String getResult(String wordToGetResult) throws Exception{
        return translatorService.callCreateTranslatedWord(wordToGetResult);
    }
}
