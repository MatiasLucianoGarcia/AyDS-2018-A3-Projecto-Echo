package ayds.dictionary.echo.model.business;

import java.util.Map;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.business.services.Source;

public interface ExceptionHandler {
    void handleException(Exception translatingWordException);
    void handleExceptions(Map<Source,Exception> exceptions);
    void setListener(TranslatorModelExceptionListener exceptionListener);
}
