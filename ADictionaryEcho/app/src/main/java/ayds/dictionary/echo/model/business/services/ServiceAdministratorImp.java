package ayds.dictionary.echo.model.business.services;

import java.util.Map;
import ayds.dictionary.echo.model.business.Source;

public class ServiceAdministratorImp implements ServiceAdministrator {

    private Map<Source,ServiceDefinition> servicesMap;

    public ServiceAdministratorImp(Map<Source,ServiceDefinition> servicesMap){
        this.servicesMap= servicesMap;
    }

    public Map<Source,ServiceDefinition> getServices(){
        return servicesMap;
    }

}
