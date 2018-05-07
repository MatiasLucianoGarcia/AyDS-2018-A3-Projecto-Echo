package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.exceptions.TranslatingWordException;

class ExceptionHandlerImpl implements ExceptionHandler {

    private TranslatorModelExceptionListener exceptionListener;

    @Override
    public void handleException(Exception translatingWordException) {
        exceptionListener.sendExceptionMessage(translatingWordException.getMessage());
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
