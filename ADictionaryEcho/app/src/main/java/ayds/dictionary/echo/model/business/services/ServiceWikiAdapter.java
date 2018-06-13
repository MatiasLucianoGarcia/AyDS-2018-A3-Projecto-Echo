package ayds.dictionary.echo.model.business.services;

import WikipediaService.APIConnection;
import WikipediaService.WikipediaServiceModule;

public class ServiceWikiAdapter implements ServiceDefinition {

    private APIConnection apiConnection = WikipediaServiceModule.getInstance().getAPIConnection();

    @Override
    public String getResult(String wordToGetResult) throws Exception {
        return apiConnection.getDefinition(wordToGetResult).getMeaning();
    }
}
