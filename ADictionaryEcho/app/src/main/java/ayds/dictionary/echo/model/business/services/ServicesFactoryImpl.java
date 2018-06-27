package ayds.dictionary.echo.model.business.services;

import com.example.yandex.service.TranslatorService;

import java.util.HashMap;
import java.util.Map;

import WikipediaService.APIConnection;
import ayds.dictionary.charlie.service.BighugelabsService;

class ServicesFactoryImpl implements ServiceFactory{

    private Map<Source,ServiceDefinition> servicesMap;

    ServicesFactoryImpl(BighugelabsService serviceBigHugLabsService, APIConnection apiConnection, TranslatorService translatorService){
        servicesMap = new HashMap<>();
        servicesMap.put(Source.BIGHUGELABS,new ServiceBigHugLabsAdapter(serviceBigHugLabsService));
        servicesMap.put(Source.WIKIPEDIA,new ServiceWikiAdapter(apiConnection));
        servicesMap.put(Source.YANDEX,new ServiceYandexAdapter(translatorService));
    }


    @Override
    public Map<Source, ServiceDefinition> getServices() {
        return servicesMap;
    }
}
