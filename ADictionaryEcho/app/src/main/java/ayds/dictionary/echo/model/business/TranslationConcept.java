package ayds.dictionary.echo.model.business;

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

    public void setTerm(String term){
        this.term = term;
    }

    public String getMeaning() {
        return meaning;
    }

    public Source getSource() {
        return source;
    }

}
