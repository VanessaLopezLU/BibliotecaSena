package com.example.bibliotecasena.interfaz;

import com.example.bibliotecasena.modelos.Rol.Rol;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RolAPI {
    @POST("rol/crear")
    <CreateRolesDto> // Ruta para crear un rol
    Call<Rol> crearRol(@Body CreateRolesDto createRolesDto);

    @GET("rol") // Ruta para obtener todos los roles
    Call<List<Rol>> obtenerRoles();

    @DELETE("rol/{id}") // Ruta para eliminar un rol por ID
    Call<Void> eliminarRol(@Path("id") int id);

    @PUT("rol/actualizar")
    <UpdateRolesDto> // Ruta para actualizar un rol
    Call<Rol> actualizarRol(@Body UpdateRolesDto updateRolesDto);

}
