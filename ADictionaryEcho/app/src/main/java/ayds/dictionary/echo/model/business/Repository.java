package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;

public interface Repository {
    String translateWord(String wordToTranslate);
    void setExceptionListener(TranslatorModelExceptionListener exceptionListener);
}
