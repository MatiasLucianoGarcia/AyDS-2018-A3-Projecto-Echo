package ayds.dictionary.echo.model.business;

public enum Source {
    NULL(""),
    YANDEX("Yandex"),
    BIGHUGLABS("BigHugLabs"),
    WIKIPEDIA("Wikipedia");

    private String name;

    Source(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}