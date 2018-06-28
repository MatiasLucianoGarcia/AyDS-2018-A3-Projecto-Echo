package ayds.dictionary.echo.model.business;

import java.util.Map;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;
import ayds.dictionary.echo.model.services.Source;
import ayds.dictionary.echo.model.exceptions.ModelNoConnectionException;
import ayds.dictionary.echo.model.exceptions.NonTranslatableWordException;

class ExceptionHandlerImpl implements ExceptionHandler {

    private TranslatorModelExceptionListener exceptionListener;

    @Override
    public void handleException(Exception translatingWordException) {
        if(translatingWordException instanceof NonTranslatableWordException)
            exceptionListener.sendExceptionMessage("Error: "+translatingWordException.getMessage());
        else
            exceptionListener.sendExceptionMessage("Error inesperado");
    }

    @Override
    public void handleExceptions(Map<Source, Exception> exceptions) {
        boolean distinctExceptions = false;
        for(Map.Entry<Source,Exception> entry : exceptions.entrySet()){
            if(!(entry.getValue() instanceof ModelNoConnectionException)){
                exceptionListener.sendExceptionMessage(entry.getKey().getName()+": Error inesperado");
                distinctExceptions = true;
            }
        }
        if(!distinctExceptions)
            exceptionListener.sendExceptionMessage("Error general: No hay conexion a internet");
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
