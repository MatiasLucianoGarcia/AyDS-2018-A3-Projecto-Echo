package ayds.dictionary.echo.model.business.services;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdministratorImp implements ServiceAdministrator {

    private List<ServiceDefinition> servicesList = new ArrayList<>();



    public Iterable<ServiceDefinition> getServices(){
        return servicesList;
    }

}
