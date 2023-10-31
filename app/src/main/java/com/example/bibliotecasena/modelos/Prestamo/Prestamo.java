package com.example.bibliotecasena.modelos.Prestamo;

import java.util.Date;

public class Prestamo {
    private int id;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private long cedula;
    private int id_estado;

    private DetallePrestamo detalle;

    public DetallePrestamo detalle() {
        return detalle;
    }

    public Prestamo setDetalle(DetallePrestamo detalle) {
        this.detalle = detalle;
        return this;
    }

    public class DetallePrestamo{
        private int tipo;

        public int tipo() {
            return tipo;
        }

        public DetallePrestamo setTipo(int tipo) {
            this.tipo = tipo;
            return this;
        }

        public int cantidad() {
            return cantidad;
        }

        public DetallePrestamo setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        private int  cantidad;
    }

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


    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public int getId_estadoprestamo() {
        return id_estado;
    }

    public void setId_estadoprestamo(int id_estadoprestamo) {
        this.id_estado = id_estadoprestamo;
    }

}
