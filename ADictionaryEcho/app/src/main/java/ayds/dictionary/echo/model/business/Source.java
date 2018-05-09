package ayds.dictionary.echo.model.business;

public enum Source {
    YANDEX("Yandex"),
    NULL("");

    private String name;

    Source(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}