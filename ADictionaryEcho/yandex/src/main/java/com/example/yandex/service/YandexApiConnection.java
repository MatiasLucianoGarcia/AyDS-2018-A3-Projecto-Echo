package com.example.yandex.service;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class YandexApiConnection {

    private Retrofit retrofit;

    void connectAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ServiceConfiguration.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    YandexAPI getYandex() {
        return retrofit.create(YandexAPI.class);
    }
}
