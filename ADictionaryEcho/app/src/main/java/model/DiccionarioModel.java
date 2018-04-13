package model;

public interface DiccionarioModel {

    void translateWord(String wordToTranslate);
    void setListener(TraductorModelListener listener);
    String getWord();

}
