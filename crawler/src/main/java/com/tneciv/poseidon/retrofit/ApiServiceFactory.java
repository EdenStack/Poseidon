package com.tneciv.poseidon.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiServiceFactory {

    private static final String BASE_URL = "http://www.luoo.net/";

    private static volatile Retrofit defaultInstance;

    private ApiServiceFactory() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    public static Retrofit getInstance() {

        if (defaultInstance == null) {
            synchronized (Retrofit.class) {
                if (defaultInstance == null) {

                    defaultInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();


                }
            }
        }

        return defaultInstance;
    }

}