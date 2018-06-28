package ayds.dictionary.echo.model.services;

public enum Source {
    NULL(""),
    YANDEX("Yandex"),
    BIGHUGELABS("BigHugeLabs"),
    WIKIPEDIA("Wikipedia");

    private String name;

    Source(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}