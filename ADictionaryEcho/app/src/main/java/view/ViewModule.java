package view;

public class ViewModule {

    private static final ViewModule ourInstance = new ViewModule();
    private FormatConverter formatConverter;

    public static ViewModule getInstance() {
        return ourInstance;
    }

    private ViewModule() {
        formatConverter = new ConverterToHTMLBoldHighlighter();
    }

    public FormatConverter getFormatConverter(){
        return formatConverter;
    }
}
