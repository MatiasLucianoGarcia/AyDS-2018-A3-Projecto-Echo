package model;

import model.exceptions.TranslatingWordException;

public interface Repository {
    String translateWord(String wordToTranslate) throws TranslatingWordException;
}
