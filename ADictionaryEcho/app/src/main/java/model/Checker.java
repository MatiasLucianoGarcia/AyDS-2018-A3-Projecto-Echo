package model;

public class Checker {
    private static  Checker instance;

    public static Checker getInstance() {
        if (instance==null){
            instance= new Checker();
        }
        return instance;
    }

    private Checker() {
    }

    public boolean characterCheck(String s){
        
    }
}
