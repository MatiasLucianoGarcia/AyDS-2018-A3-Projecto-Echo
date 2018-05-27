package ayds.dictionary.echo.model.business;

public enum Source {
    NULL(""),
    YANDEX("Yandex");

    private String name;

    Source(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}