package ayds.dictionary.echo.model.service;

import ayds.dictionary.echo.model.exceptions.NoConnectionException;

public interface TranslatorService {
    String callCreateTranslatedWord(String wordToTranslate) throws NoConnectionException;
}
