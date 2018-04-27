package model.service;

import model.exceptions.NoConnectionException;

public interface TranslatorService {
    String callCreateTranslatedWord(String wordToTranslate) throws NoConnectionException;
}
