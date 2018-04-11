package model;

import android.content.Context;

public interface StorageInterface {


    void createNewDatabase(Context context);

    void saveTerm(String term, String meaning);

    String getMeaning(String term);
}
