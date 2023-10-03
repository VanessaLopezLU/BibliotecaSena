package com.example.bibliotecasena.modelos.Prestamo;

import java.util.Date;

public class Prestamo {
    private int id;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private int cantidad;
    private int cedula;
    private int id_estadoprestamo;
    private int equipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getId_estadoprestamo() {
        return id_estadoprestamo;
    }

    public void setId_estadoprestamo(int id_estadoprestamo) {
        this.id_estadoprestamo = id_estadoprestamo;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
}
