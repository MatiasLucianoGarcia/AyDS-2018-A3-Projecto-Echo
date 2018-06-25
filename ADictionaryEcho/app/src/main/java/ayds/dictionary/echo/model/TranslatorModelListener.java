package ayds.dictionary.echo.model;

import java.util.List;

import ayds.dictionary.echo.model.business.TranslationConcept;

public interface TranslatorModelListener {
    void didUpdateWord(List<TranslationConcept> translatedWords);
}
