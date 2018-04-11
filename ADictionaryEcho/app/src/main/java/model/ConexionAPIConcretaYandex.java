package model;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ConexionAPIConcretaYandex implements ConexionAPIInterface {

    protected Retrofit retrofit;

    public void conectarAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public YandexAPI getYandex() {
        return retrofit.create(YandexAPI.class);
    }
}
