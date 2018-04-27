package model.exceptions;

public class NonTranslatableWordException extends TranslatingWordException {

    private static final String ERROR_MESSAGE = "No se ha ingresado una palabra traducible";

    public NonTranslatableWordException() {
        super(ERROR_MESSAGE);
    }
}
