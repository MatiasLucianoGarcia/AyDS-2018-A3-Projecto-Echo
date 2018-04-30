package ayds.dictionary.echo.model.exceptions;

public class NoConnectionException extends TranslatingWordException {

    private static final String ERROR_MESSAGE = "No hay conexion a Internet";

    public NoConnectionException() {
        super(ERROR_MESSAGE);
    }
}
