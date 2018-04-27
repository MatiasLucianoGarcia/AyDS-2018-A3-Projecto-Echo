package model.exceptions;

public class NoConnectionException extends TranslatingWordException {
    public NoConnectionException(String errorMessage) {
        super(errorMessage);
    }
}
