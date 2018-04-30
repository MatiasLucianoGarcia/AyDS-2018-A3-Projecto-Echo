package ayds.dictionary.echo.model;

public interface TranslatorModel {
    void translateWord(String wordToTranslate);
    void setListener(TranslatorModelListener listener);
    void setExceptionListener(TranslatorModelExceptionListener translatorModelExceptionListener);
}
