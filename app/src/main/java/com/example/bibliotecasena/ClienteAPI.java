package com.example.bibliotecasena;
import com.example.bibliotecasena.modelos.User.User;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteAPI {

    public static Retrofit getCLient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://18.117.99.105:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
