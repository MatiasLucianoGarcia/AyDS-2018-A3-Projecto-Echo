package ayds.dictionary.echo.model.business.services;

import java.util.Map;

import ayds.dictionary.echo.model.business.Source;

/**
 * Created by tomas on 25/6/2018.
 */

public interface ServiceFactory {
    Map<Source,ServiceDefinition> getServices();
}
