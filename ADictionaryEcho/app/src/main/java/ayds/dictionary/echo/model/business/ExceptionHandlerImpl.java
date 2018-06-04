package ayds.dictionary.echo.model.business;

import com.example.yandex.service.NoConnectionException;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

class ExceptionHandlerImpl implements ExceptionHandler {

    private TranslatorModelExceptionListener exceptionListener;

    @Override
    public void handleException(Exception translatingWordException) {
        if(translatingWordException instanceof NoConnectionException || translatingWordException instanceof NonTranslatableWordException)
            exceptionListener.sendExceptionMessage(translatingWordException.getMessage());
        else
            exceptionListener.sendExceptionMessage("Error inesperado");
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
