package ayds.dictionary.echo.model.services;

import java.util.Set;

public interface ServiceAdministrator {
    Set<Source> getServices();
    String getMeaningBySource(Source source,String wordToTranslate) throws Exception;
}
