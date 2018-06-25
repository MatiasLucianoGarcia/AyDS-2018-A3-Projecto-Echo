package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.exceptions.TranslatingWordException;

public interface ExceptionHandler {
    void handleException(Exception translatingWordException,Source source);
    void setListener(TranslatorModelExceptionListener exceptionListener);
}
