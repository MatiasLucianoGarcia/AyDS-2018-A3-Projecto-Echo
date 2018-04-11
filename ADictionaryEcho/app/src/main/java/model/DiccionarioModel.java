package model;

public interface DiccionarioModel {

    public void guardarTermino(String term, String sig);

    public String retornarSignificado(String term);
}
