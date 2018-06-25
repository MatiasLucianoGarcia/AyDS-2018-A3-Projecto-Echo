package ayds.dictionary.echo.model.business.services;

import WikipediaService.APIConnection;

public class ServiceWikiAdapter implements ServiceDefinition {

    private APIConnection apiConnection;

    public ServiceWikiAdapter(APIConnection apiConnection){
        this.apiConnection=apiConnection;
    }

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        return apiConnection.getDefinition(wordToGetResult).getMeaning();
    }
}
