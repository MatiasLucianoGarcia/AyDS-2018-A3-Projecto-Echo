package ayds.dictionary.echo.model;

class SpellingChecker {

    private SpellingChecker() {
    }

    static boolean isCorrect(String text){
        return !(isFullWhiteSpaces(text)|| hasKeys(text) || hasBrackets(text)|| isNull(text));
    }

    private static boolean isFullWhiteSpaces(String s){
        return s.trim().length()==0;
    }

    private static boolean hasKeys(String s){
        return s.contains("{") || s.contains("}");
    }

    private static boolean hasBrackets(String s){
        return s.contains("[") || s.contains("]");
    }

    private static boolean isNull(String s){
        return (s==null) || (s.equals(""));
    }
}

