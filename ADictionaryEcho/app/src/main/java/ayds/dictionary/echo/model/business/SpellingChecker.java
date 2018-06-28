package ayds.dictionary.echo.model.business;

public class SpellingChecker {

    private SpellingChecker() {
    }

    public static boolean isOnlyAlphabetic(String text){
        return !(isFullWhiteSpaces(text) || isNull(text)) && isAlphabetic(text);
    }

    public static boolean isOnlyAlphabeticAndNumeric(String text){
        return !(isFullWhiteSpaces(text) || isNull(text)) && isAlphabeticAndNumeric(text);
    }

    public static boolean isOnlyOneWord(String text){
        return !(isFullWhiteSpaces(text) || isNull(text)) && isAlphabeticAndNumericAndUnique(text);
    }

    private static boolean isAlphabeticAndNumericAndUnique(String name) {
        return name.matches("[a-zA-Z0-9]+");
    }

    private static boolean isFullWhiteSpaces(String s){
        return s.trim().length()==0;
    }

    private static boolean isAlphabetic(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    private static boolean isAlphabeticAndNumeric(String name) {
        return name.matches("[a-zA-Z0-9 ]+");
    }

    private static boolean isNull(String s){
        return (s==null) || (s.equals(""));
    }
}

