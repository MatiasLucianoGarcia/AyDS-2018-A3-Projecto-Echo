package ayds.dictionary.echo.model.business.services;

import java.util.Map;
import java.util.Set;

class ServiceAdministratorImp implements ServiceAdministrator {

    private Map<Source,ServiceDefinition> servicesMap;

    ServiceAdministratorImp(Map<Source,ServiceDefinition> servicesMap){
        this.servicesMap= servicesMap;
    }

    public Set<Source> getServices(){
        return servicesMap.keySet();
    }

    @Override
    public String getMeaningBySource(Source source, String wordToTranslate) throws Exception {
        String translatedWord = servicesMap.get(source).getResult(wordToTranslate);
        if(translatedWord == null)
            translatedWord = "";
        return translatedWord;
    }

}
