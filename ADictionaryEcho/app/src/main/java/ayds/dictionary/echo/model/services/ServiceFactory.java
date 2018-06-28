package ayds.dictionary.echo.model.services;

import java.util.Map;

/**
 * Created by tomas on 25/6/2018.
 */

public interface ServiceFactory {
    Map<Source,ServiceDefinition> getServices();
}
