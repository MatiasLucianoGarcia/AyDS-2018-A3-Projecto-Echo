package ayds.dictionary.echo.model;

enum Sources{
    YANDEX(1);

    private final int value;

    Sources(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
