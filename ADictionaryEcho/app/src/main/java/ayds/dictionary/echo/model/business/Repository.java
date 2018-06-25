package ayds.dictionary.echo.model.business;

import java.util.List;

import ayds.dictionary.echo.model.TranslatorModelExceptionListener;

public interface Repository {
    List<TranslationConcept> translateWord(String wordToTranslate);
    void setExceptionListener(TranslatorModelExceptionListener exceptionListener);
}
