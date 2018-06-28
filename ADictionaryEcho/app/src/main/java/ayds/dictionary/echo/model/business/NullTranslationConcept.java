package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.services.Source;

public class NullTranslationConcept extends TranslationConcept {

    public NullTranslationConcept() {
        super("", "", Source.NULL);
    }
}
