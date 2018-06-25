package ayds.dictionary.echo.model.business.services;
import java.util.Map;
import ayds.dictionary.echo.model.business.Source;

public interface ServiceAdministrator {
    Map<Source,ServiceDefinition> getServices();
}
