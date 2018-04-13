package model;

public interface DiccionarioModel {

    void guardarTermino(String term, String sig);
    void setListener(TraductorModelListener listener);
    String getWord();

}
