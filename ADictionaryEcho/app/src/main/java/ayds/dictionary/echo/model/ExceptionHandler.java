package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.exceptions.TranslatingWordException;

public interface ExceptionHandler {
    void handleException(TranslatingWordException translatingWordException);
    void setListener(TranslatorModelExceptionListener exceptionListener);
}
