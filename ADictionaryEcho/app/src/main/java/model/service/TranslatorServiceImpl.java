package model.service;

import java.io.IOException;

import retrofit2.Response;

class TranslatorServiceImpl implements TranslatorService {

    private YandexAPI service;
    private ResultConverter resultConverter;

    public TranslatorServiceImpl(YandexAPI service, ResultConverter resultConverter) {
        this.service = service;
        this.resultConverter=resultConverter;
    }

    public String callCreateTranslatedWord(String wordToTranslate) {
        Response<String> callResponse=null;
        try {
            callResponse = service.getTerm(wordToTranslate).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String  resultToConvert = callResponse.body();
        return resultConverter.createTranslatorResult(resultToConvert);
    }
}
