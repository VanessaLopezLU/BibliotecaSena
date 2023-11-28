package com.example.bibliotecasena.interfaz;

import com.example.bibliotecasena.modelos.Prestamo.Prestamo;
import com.example.bibliotecasena.modelos.Rol.Rol;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PrestamoAPI {

    @POST("prestamo/crear")
    <CreatePrestamoDto> // Ruta para crear un prestamo
    Call<Prestamo> crearPrestamo(@Body CreatePrestamoDto createPrestamoDto);

    @GET("prestamo")
    Call<List<Prestamo>> ObtenerPrestamo();

    @GET("prestamo/obtenerPrestamoPorCedula/{cedula}")
    Call<List<Prestamo>> ObtenerPrestamoPorCeddula(@Path("cedula") long cedula);


    @DELETE("prestamo/{id}") // Ruta para eliminar un prestamo  por ID
    Call<Void> eliminarPrestamo(@Path("id") int id);

}
