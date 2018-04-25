package view;

class ConverterToHTMLBoldHighlighter implements FormatConverter {

    public String formatTo(String text, String term) {
        text = text.replace("\\n", "<br>");
        StringBuilder builder = new StringBuilder();
        String textWithBold = text.replaceAll("(?i)" + term, "<b>" + term + "</b>");
        builder.append(textWithBold);
        return builder.toString();
    }
}
