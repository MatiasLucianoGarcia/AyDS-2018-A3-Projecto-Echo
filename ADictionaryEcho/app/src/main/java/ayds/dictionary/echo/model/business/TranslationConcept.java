package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.services.Source;

public class TranslationConcept {

    private String term;
    private String meaning;
    private Source source;

    public TranslationConcept(String term, String meaning, Source source) {
        this.term = term;
        this.meaning = meaning;
        this.source = source;
    }

    public String getTerm() {
        return term;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Source getSource() {
        return source;
    }

}
