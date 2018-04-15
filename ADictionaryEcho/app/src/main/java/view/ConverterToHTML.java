package model;

/**
 * Created by tomas on 11/4/2018.
 */

public class ConverterToHTML implements FormatConverter {

    public String formatTo(String text, String term) {

        StringBuilder builder = new StringBuilder();

        String textWithBold = text.replaceAll("(?i)" + term, "<b>" + term + "</b>");

        builder.append(textWithBold);

        return builder.toString();
    }
}
