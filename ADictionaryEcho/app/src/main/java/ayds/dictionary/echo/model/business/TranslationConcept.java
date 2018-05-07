package ayds.dictionary.echo.model.business;

public class TranslationConcept {

    private String term;
    private String meaning;
    private int source;

    public TranslationConcept(String term, String meaning, int source) {
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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
