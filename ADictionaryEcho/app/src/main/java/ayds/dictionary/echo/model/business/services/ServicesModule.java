package ayds.dictionary.echo.model.business.services;

/**
 * Created by tomas on 13/6/2018.
 */

public class ServicesModule {
    private static final ServicesModule ourInstance = new ServicesModule();

    public static ServicesModule getInstance() {
        return ourInstance;
    }

    private ServicesModule() {
    }
}
