package model;

public class DiccionarioModelConcreta implements DiccionarioModel {

    public DiccionarioModelConcreta() {}

    public void guardarTermino(String term, String sig) {
        DataBase.saveTerm(term,sig);
    }

    public String retornarSignificado(String term) {
         return DataBase.getMeaning(term);
    }
}
