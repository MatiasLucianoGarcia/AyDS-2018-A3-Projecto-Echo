package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.business.services.Source;

public class NullTranslationConcept extends TranslationConcept {

    public NullTranslationConcept() {
        super("", "", Source.NULL);
    }
}
