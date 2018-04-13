package model.service;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class YandexApiConnection {

    protected Retrofit retrofit;

    public void conectarAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ServiceConfiguration.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public YandexAPI getYandex() {
        return retrofit.create(YandexAPI.class);
    }
}
