package com.example.bibliotecasena.interfaz;

import com.example.bibliotecasena.modelos.EstadoUsuario.EstadoUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PrestamoAPI {
    @POST("prestamo/crear")
    <CreatePrestamoDto> // Ruta para crear un Estado Usuario
    Call<EstadoUsuario> crearPrestamo(@Body CreatePrestamoDto createPrestamoDto);

    @GET("estado-usuario") // Ruta para obtener todos los Estados de  Usuario
    Call<List<EstadoUsuario>> obtenerEstado();

    @DELETE("estado-usuario/{id}") // Ruta para eliminar un Estado Usuario por ID
    Call<Void> eliminarEstado(@Path("id") int id);

    @PUT("estado-usuario/actualizar")
    <UpdateEstadoUsuarioDto> // Ruta para actualizar un Estado Usuario
    Call<EstadoUsuario> actualizarEstado(@Body UpdateEstadoUsuarioDto  updateEstadoUsuarioDto);





}
