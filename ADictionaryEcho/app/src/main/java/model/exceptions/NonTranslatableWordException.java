package model.exceptions;

public class NonTranslatableWordException extends TranslatingWordException {
    public NonTranslatableWordException(String errorMessage) {
        super(errorMessage);
    }
}
