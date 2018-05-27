package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.business.TranslationConcept;

public interface TranslatorModelListener {
    void didUpdateWord(TranslationConcept translatedWord);
}
