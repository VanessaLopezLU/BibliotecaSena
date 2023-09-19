package com.example.bibliotecasena;

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

    @GET("user/obtener")
    Call<List<User>> getUsers(@Path("id")int userid);

    @DELETE("user/eliminar/{cedula}")
    Call<Void> deleteUser(@Path("cedula") int cedula);

    @PUT("user/actualizar")
    Call<User> updateUser(@Body User user);
}
