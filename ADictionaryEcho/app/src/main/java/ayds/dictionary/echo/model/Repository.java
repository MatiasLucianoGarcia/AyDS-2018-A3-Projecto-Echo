package ayds.dictionary.echo.model;

public interface Repository {
    String translateWord(String wordToTranslate);
    void setExceptionListener(TranslatorModelExceptionListener exceptionListener);
}
