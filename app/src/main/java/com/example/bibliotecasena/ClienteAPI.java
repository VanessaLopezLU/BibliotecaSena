package com.example.bibliotecasena;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteAPI {
    public static Retrofit getClient() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.187.131.12:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
    }
}
