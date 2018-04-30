package ayds.dictionary.echo.model.storage;

import android.arch.persistence.room.Room;
import android.content.Context;

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

    public void saveTerm(String term, String meaning) {
        Concept concept =  new Concept();
        concept.setTerm(term);
        concept.setMeaning(meaning);
        concept.setSource(1);
        db.termDao().insert(concept);
    }

    public String getMeaning(String term) {
        Concept concept = db.termDao().findByName(term);
        if (concept != null) {
            return concept.getMeaning();
        }
        return null;
    }
}