package ayds.dictionary.echo.model.exceptions;

public class ModelNoConnectionException extends TranslatingWordException{

    private static final String ERROR_MESSAGE = "No hay conexion a Internet";

    public ModelNoConnectionException() {
            super(ERROR_MESSAGE);
        }
}
