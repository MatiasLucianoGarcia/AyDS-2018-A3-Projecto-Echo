package ayds.dictionary.echo.model.storage;

import android.arch.persistence.room.Room;
import android.content.Context;

import ayds.dictionary.echo.model.business.NullTranslationConcept;
import ayds.dictionary.echo.model.business.services.Source;
import ayds.dictionary.echo.model.business.TranslationConcept;
import ayds.dictionary.echo.model.storage.room.*;

class DataBase implements Storage {

    private static DataBase instance;
    private static ConceptDataBase db;

    private DataBase() {}

    static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void createNewDatabase(Context context) {
        db = Room.databaseBuilder(context,
                ConceptDataBase.class, "dictionary.db").build();
    }

    public void saveTerm(TranslationConcept translationConcept) {
        Concept concept =  new Concept();
        concept.setTerm(translationConcept.getTerm());
        concept.setMeaning(translationConcept.getMeaning());
        concept.setSource(translationConcept.getSource().ordinal());
        db.termDao().insert(concept);
    }

    public TranslationConcept getMeaning(String term, Source source) {
        Concept concept = db.termDao().findByNameAndSource(term, source.ordinal());
        if (concept != null) {
            return new TranslationConcept(term,concept.getMeaning(), Source.values()[concept.getSource()]);
        }
        return new NullTranslationConcept();
    }
}