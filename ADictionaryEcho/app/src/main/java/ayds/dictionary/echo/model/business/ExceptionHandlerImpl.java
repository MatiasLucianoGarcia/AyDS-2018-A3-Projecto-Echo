package ayds.dictionary.echo.model.business;

import com.example.yandex.service.NoConnectionException;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

class ExceptionHandlerImpl implements ExceptionHandler {

    private TranslatorModelExceptionListener exceptionListener;

    @Override
    public void handleException(Exception translatingWordException, Source source) {
        if(translatingWordException instanceof NoConnectionException || translatingWordException instanceof NonTranslatableWordException)
            exceptionListener.sendExceptionMessage(source.getName()+": "+translatingWordException.getMessage());
        else
            exceptionListener.sendExceptionMessage(source.getName()+": Error inesperado");
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
