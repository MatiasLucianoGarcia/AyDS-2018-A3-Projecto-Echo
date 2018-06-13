package ayds.dictionary.echo.model.business.services;

import com.example.yandex.service.YandexModule;
import com.example.yandex.service.TranslatorService;

public class ServiceYandexAdapter implements ServiceDefinition {

    private TranslatorService translatorService = YandexModule.getInstance().getTranslatorService();

    @Override
    public String getResult(String wordToGetResult) throws Exception{
        return translatorService.callCreateTranslatedWord(wordToGetResult);
    }
}
