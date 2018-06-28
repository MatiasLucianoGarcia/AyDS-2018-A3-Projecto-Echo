package ayds.dictionary.echo.model;

import java.util.Map;

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
        String exceptionMessage = "";
        for(Map.Entry<Source,Exception> entry : exceptions.entrySet()){
            if(entry.getValue() instanceof NonTranslatableWordException || entry.getValue() instanceof ModelNoConnectionException)
                exceptionMessage += entry.getKey().getName() + ": "+entry.getValue().getMessage()+"\n";
            else
                exceptionMessage += entry.getKey().getName() + ": Error inesperado\n";
        }
        exceptionListener.sendExceptionMessage(exceptionMessage);
    }

    @Override
    public void setListener(TranslatorModelExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }
}
