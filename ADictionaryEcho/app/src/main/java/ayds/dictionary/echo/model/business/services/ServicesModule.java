package ayds.dictionary.echo.model.business.services;

import com.example.yandex.service.TranslatorService;
import com.example.yandex.service.YandexModule;

import WikipediaService.APIConnection;
import WikipediaService.WikipediaServiceModule;
import ayds.dictionary.charlie.service.BighugelabsService;
import ayds.dictionary.charlie.service.BighugelabsServiceModule;

public class ServicesModule {

    private static final ServicesModule ourInstance = new ServicesModule();

    private ServiceAdministrator serviceAdministrator;

    public static ServicesModule getInstance() {
        return ourInstance;
    }

    private ServicesModule() {
        BighugelabsService bighugelabsService = BighugelabsServiceModule.getInstance().getBighugelabsService();
        APIConnection apiConnection = WikipediaServiceModule.getInstance().getAPIConnection();
        TranslatorService translatorService = YandexModule.getInstance().getTranslatorService();
        ServicesFactoryImpl servicesFactoryImpl = new ServicesFactoryImpl(bighugelabsService,apiConnection,translatorService);
        serviceAdministrator = new ServiceAdministratorImp(servicesFactoryImpl.getServices());
    }

    public ServiceAdministrator getServiceAdministrator(){
        return serviceAdministrator;
    }
}
