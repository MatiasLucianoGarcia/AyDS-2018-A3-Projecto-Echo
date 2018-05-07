package ayds.dictionary.echo.model;

class SpellingChecker {

    private SpellingChecker() {
    }

    static boolean isCorrect(String text){
        return !(isFullWhiteSpaces(text) || isNull(text)) && isAlphabetic(text);
    }

    private static boolean isFullWhiteSpaces(String s){
        return s.trim().length()==0;
    }

    private static boolean isAlphabetic(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isNull(String s){
        return (s==null) || (s.equals(""));
    }
}

