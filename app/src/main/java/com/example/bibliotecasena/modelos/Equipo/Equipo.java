package com.example.bibliotecasena.modelos.Equipo;

public class Equipo {
     private int id;
     private  String serial;
     private String descripcion;
     private int id_estado;
     private  int id_tipo;

     public int id() {
          return id;
     }

     public Equipo setId(int id) {
          this.id = id;
          return this;
     }

     public String serial() {
          return serial;
     }

     public Equipo setSerial(String serial) {
          this.serial = serial;
          return this;
     }

     public String descripcion() {
          return descripcion;
     }

     public Equipo setDescripcion(String descripcion) {
          this.descripcion = descripcion;
          return this;
     }

     public int id_estado() {
          return id_estado;
     }

     public Equipo setId_estado(int id_estado) {
          this.id_estado = id_estado;
          return this;
     }

     public int id_tipo() {
          return id_tipo;
     }

     public Equipo setId_tipo(int id_tipo) {
          this.id_tipo = id_tipo;
          return this;
     }
}

