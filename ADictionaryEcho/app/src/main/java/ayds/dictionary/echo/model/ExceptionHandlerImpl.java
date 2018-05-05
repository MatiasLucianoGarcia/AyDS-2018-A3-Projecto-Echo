package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.exceptions.TranslatingWordException;

class ExceptionHandlerImpl implements ExceptionHandler {

    private TranslatorModelExceptionListener exceptionListener;

    @Override
    public void handleException(TranslatingWordException translatingWordException) {
        exceptionListener.sendExceptionMessage(translatingWordException.getMessage());
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
