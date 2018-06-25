package ayds.dictionary.echo.model.business.services;

import ayds.dictionary.charlie.service.BighugelabsService;
import ayds.dictionary.charlie.service.BighugelabsServiceModule;

public class ServiceBigHugLabsAdapter implements ServiceDefinition {

    BighugelabsService bighugelabsService;

    public ServiceBigHugLabsAdapter (BighugelabsService bighugelabsService){
        this.bighugelabsService=bighugelabsService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        return bighugelabsService.searchWord(wordToGetResult);
    }
}
