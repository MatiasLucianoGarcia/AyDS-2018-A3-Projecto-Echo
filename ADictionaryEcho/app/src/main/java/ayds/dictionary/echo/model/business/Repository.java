package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;

public interface Repository {
    TranslationConcept translateWord(String wordToTranslate);
    void setExceptionListener(TranslatorModelExceptionListener exceptionListener);
}
