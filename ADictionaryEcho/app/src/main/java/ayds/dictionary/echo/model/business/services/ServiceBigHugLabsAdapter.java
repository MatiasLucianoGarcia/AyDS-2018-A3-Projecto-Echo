package ayds.dictionary.echo.model.business.services;

import java.io.IOException;

import ayds.dictionary.charlie.service.BighugelabsService;
import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;

class ServiceBigHugLabsAdapter implements ServiceDefinition {

    private BighugelabsService bighugelabsService;

    ServiceBigHugLabsAdapter (BighugelabsService bighugelabsService){
        this.bighugelabsService=bighugelabsService;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        String result = "";
        try{
            result = bighugelabsService.searchWord(wordToGetResult);
        }
        catch (IOException exception){
            throw new ModelNoConnectionException();
        }
        return result;
    }
}
