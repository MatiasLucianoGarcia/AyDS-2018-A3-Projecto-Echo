package ayds.dictionary.echo.model.business;

import ayds.dictionary.echo.model.ModelModule;
import ayds.dictionary.echo.model.services.ServicesModule;
import ayds.dictionary.echo.model.storage.StorageModule;

public class BusinessModule {
  private static final BusinessModule ourInstance = new BusinessModule();

  public static BusinessModule getInstance() {
    return ourInstance;
  }

  private BusinessModule() {
  }

  public Repository getRepository() {
    return new RepositoryImpl(
        StorageModule.getInstance().getDataBase(),
        ServicesModule.getInstance().getServiceAdministrator(),
        ModelModule.getInstance().getExceptionHandler()
    );
  }
}
