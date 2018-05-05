package ayds.dictionary.echo.model;

public class TranslationConcept {

    private String term;
    private String meaning;
    private String source;

    public TranslationConcept(String term, String meaning, String source) {
        this.term = term;
        this.meaning = meaning;
        this.source = source;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
