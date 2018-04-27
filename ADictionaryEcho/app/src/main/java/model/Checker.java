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

    public boolean isCorrect(String s){
        return !(hasSpaceContinous(s)|| hasKeys(s) || hasBrackets(s));
    }

    private boolean hasSpaceContinous(String s){
        return s.contains("  ");
    }

    private boolean hasKeys(String s){
        return s.contains("{") || s.contains("}");
    }

    private boolean hasBrackets(String s){
        return s.contains("[") || s.contains("]");
    }
}

