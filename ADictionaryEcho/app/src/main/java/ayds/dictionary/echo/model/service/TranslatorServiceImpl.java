package ayds.dictionary.echo.model.service;

import java.io.IOException;

import ayds.dictionary.echo.model.exceptions.NoConnectionException;
import retrofit2.Response;

class TranslatorServiceImpl implements TranslatorService {

    private YandexAPI service;
    private ResultConverter resultConverter;

    TranslatorServiceImpl(YandexAPI service, ResultConverter resultConverter) {
        this.service = service;
        this.resultConverter = resultConverter;
    }

    public String callCreateTranslatedWord(String wordToTranslate) throws NoConnectionException {
        Response<String> callResponse;
        try {
            callResponse = service.getTerm(wordToTranslate).execute();
        } catch (IOException e) {
            throw new NoConnectionException();
        }

        String resultToConvert;
        try {
            resultToConvert = callResponse.body();
        }
        catch(NullPointerException exception){
            throw new NoConnectionException();
        }

        return resultConverter.createTranslatorResult(resultToConvert);
    }
}
