package ayds.dictionary.echo.model;

import java.util.Map;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.services.Source;

public interface ExceptionHandler {
    void handleException(Exception translatingWordException);
    void handleExceptions(Map<Source,Exception> exceptions);
    void setListener(TranslatorModelExceptionListener exceptionListener);
}
