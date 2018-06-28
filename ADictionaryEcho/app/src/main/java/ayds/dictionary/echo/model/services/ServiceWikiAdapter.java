package ayds.dictionary.echo.model.services;

import WikipediaService.APIConnection;
import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;

class ServiceWikiAdapter implements ServiceDefinition {

    private APIConnection apiConnection;

    ServiceWikiAdapter(APIConnection apiConnection){
        this.apiConnection=apiConnection;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        String result = "";
        try{
            result = apiConnection.getDefinition(wordToGetResult).getMeaning();
        }
        catch(Exception exception){
            if(exception.getMessage().contains("No se pudo conectar con la Wikipedia."))
                throw new ModelNoConnectionException();
            else
                throw exception;
        }
        return result;
    }
}
