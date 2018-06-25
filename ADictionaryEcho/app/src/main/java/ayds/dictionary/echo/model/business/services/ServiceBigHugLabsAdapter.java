package ayds.dictionary.echo.model.business.services;

import ayds.dictionary.charlie.service.BighugelabsService;

public class ServiceBigHugLabsAdapter implements ServiceDefinition {

    private BighugelabsService bighugelabsService;

    public ServiceBigHugLabsAdapter (BighugelabsService bighugelabsService){
        this.bighugelabsService=bighugelabsService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        return bighugelabsService.searchWord(wordToGetResult);
    }
}
