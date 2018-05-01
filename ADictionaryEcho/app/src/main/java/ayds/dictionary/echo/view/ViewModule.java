package ayds.dictionary.echo.view;

import android.content.Context;

public class ViewModule {

    private static final ViewModule ourInstance = new ViewModule();
    private FormatConverter formatConverter;
    private Context applicationContext;

    public static ViewModule getInstance() {
        return ourInstance;
    }

    private ViewModule() {
        formatConverter = new ConverterToHTMLBoldHighlighter();
    }

    FormatConverter getFormatConverter(){
        return formatConverter;
    }

    void setApplicationContext(Context context){
        this.applicationContext = context;
    }

    public Context getApplicationContext(){
        return applicationContext;
    }
}
