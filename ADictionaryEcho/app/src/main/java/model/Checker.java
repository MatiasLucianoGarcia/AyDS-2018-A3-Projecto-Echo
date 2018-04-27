package model;

public class Checker {
    private Checker() {
    }

    public static boolean isCorrect(String s){
        return !(hasSpaceContinous(s)|| hasKeys(s) || hasBrackets(s)|| isNull(s));
    }

    private static boolean hasSpaceContinous(String s){
        return s.contains("  ");
    }

    private static boolean hasKeys(String s){
        return s.contains("{") || s.contains("}");
    }

    private static boolean hasBrackets(String s){
        return s.contains("[") || s.contains("]");
    }

    private static boolean isNull(String s){
        return (s==null) || (s=="");
    }
}

