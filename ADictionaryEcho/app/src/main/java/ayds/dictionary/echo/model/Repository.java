package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.exceptions.TranslatingWordException;

public interface Repository {
    String translateWord(String wordToTranslate) throws TranslatingWordException;
}
