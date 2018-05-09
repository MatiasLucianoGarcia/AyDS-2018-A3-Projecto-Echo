package ayds.dictionary.echo.model.storage;

import android.content.Context;

import ayds.dictionary.echo.model.business.TranslationConcept;

public interface Storage {
    void createNewDatabase(Context context);
    void saveTerm(TranslationConcept translationConcept);
    TranslationConcept getMeaning(String term);
}
