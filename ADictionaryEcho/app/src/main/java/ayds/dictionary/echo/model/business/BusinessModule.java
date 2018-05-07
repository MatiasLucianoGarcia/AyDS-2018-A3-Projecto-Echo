package ayds.dictionary.echo.model.business;


import com.example.yandex.service.ServiceModule;
import ayds.dictionary.echo.model.storage.StorageModule;

public class BusinessModule {
    private static final BusinessModule ourInstance = new BusinessModule();

    public static BusinessModule getInstance() {
        return ourInstance;
    }

    private BusinessModule() {
    }

    public Repository getRepository(){
        return new RepositoryImpl(StorageModule.getInstance().getDataBase(), ServiceModule.getInstance().getTranslatorService(),new ExceptionHandlerImpl());
    }
}
