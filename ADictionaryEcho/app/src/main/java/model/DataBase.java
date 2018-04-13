package model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;

import model.room.*;

//TODO Hacer la base de datos singleton y refacotrear el codigo donde se usa
public class DataBase  implements StorageInterface{

  private static ConceptDataBase db;


  public  void createNewDatabase(Context context) {
    db = Room.databaseBuilder(context,
                              ConceptDataBase.class, "dictionary.db").build();
  }

  public static void testDB() {

    List<Concept> concepts = db.termDao().getAll();

    for (Concept concept :
        concepts) {
      Log.e("**", "id =" + concept.getId());
      Log.e("**", "term =" + concept.getTerm());
      Log.e("**", "meaning =" + concept.getMeaning());
      Log.e("**", "source =" + concept.getSource());

    }
  }

  public void saveTerm(String term, String meaning) {
    Concept concept =  new Concept();
    concept.setTerm(term);
    concept.setMeaning(meaning);
    concept.setSource(1);
    db.termDao().insert(concept);
  }

  public  String getMeaning(String term) {

    Concept concept = db.termDao().findByName(term);

    if (concept != null) {
      return concept.getMeaning();
    }
    return null;
  }



}
