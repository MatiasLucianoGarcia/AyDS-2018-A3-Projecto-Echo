package ayds.dictionary.echo.model.storage;

import android.content.Context;

public interface Storage {
    void createNewDatabase(Context context);
    void saveTerm(String term, String meaning);
    String getMeaning(String term);
}
