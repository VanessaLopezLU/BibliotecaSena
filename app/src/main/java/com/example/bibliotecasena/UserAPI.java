package com.example.bibliotecasena;

import com.example.bibliotecasena.modelos.User.ApiResponse;
import com.example.bibliotecasena.modelos.User.LoginDto;
import com.example.bibliotecasena.modelos.User.User;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface UserAPI {
    @POST("user/crear")
    Call<User> createUser(@Body User user);
    @POST("user/login")
    Call<ApiResponse> loginUser(@Body LoginDto loginDto);

    @GET("user/")
    Call<List<User>> getUsers(@Path("id")int userid);

    @DELETE("user/{cedula}")
    Call<Void> deleteUser(@Path("cedula") int cedula);

    @PUT("user/actualizar")
    Call<User> updateUser(@Body User user);

}
