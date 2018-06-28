package ayds.dictionary.echo.model.business;

import java.util.List;

import ayds.dictionary.echo.model.ExceptionHandler;

public interface Repository {
    List<TranslationConcept> translateWord(String wordToTranslate);
}
