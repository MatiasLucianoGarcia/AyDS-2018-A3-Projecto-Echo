package ayds.dictionary.echo.model.exceptions;

public abstract class TranslatingWordException extends Exception {
    TranslatingWordException(String errorMessage) {
        super(errorMessage);
    }
}
