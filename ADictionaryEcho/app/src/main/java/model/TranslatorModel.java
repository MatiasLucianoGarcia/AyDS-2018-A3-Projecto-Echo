package model;

public interface TranslatorModel {

    void translateWord(String wordToTranslate);
    void setListener(TranslatorModelListener listener);

}
