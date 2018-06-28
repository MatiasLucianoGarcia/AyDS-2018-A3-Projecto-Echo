package ayds.dictionary.echo.model;

import ayds.dictionary.echo.model.business.BusinessModule;

public class ModelModule {

  private static ModelModule instance;
  private TranslatorModel translatorModel;
  private ExceptionHandler exceptionHandler;

  private ModelModule() {
    exceptionHandler = new ExceptionHandlerImpl();
  }

  public static ModelModule getInstance() {
    if (instance == null) {
      instance = new ModelModule();
    }
    return instance;
  }

  public void initTranslatorModel() {
    translatorModel = new TranslatorModelImpl(BusinessModule.getInstance().getRepository(), exceptionHandler);
  }

  public TranslatorModel getTranslatorModel() {
    return translatorModel;
  }

  public ExceptionHandler getExceptionHandler() {
    return exceptionHandler;
  }
}
