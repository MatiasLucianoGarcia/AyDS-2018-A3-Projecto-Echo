package ayds.dictionary.echo.model.business.services;

public class ServicesModule {

    private static final ServicesModule ourInstance = new ServicesModule();

    private ServiceAdministrator serviceAdministrator;

    public static ServicesModule getInstance() {
        return ourInstance;
    }

    private ServicesModule() {
        serviceAdministrator = new ServiceAdministratorImp();
    }

    public ServiceAdministrator getServiceAdministrator(){
        return serviceAdministrator;
    }
}
