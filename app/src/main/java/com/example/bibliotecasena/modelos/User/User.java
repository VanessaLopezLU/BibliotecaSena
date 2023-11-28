package com.example.bibliotecasena.modelos.User;

import java.util.stream.Stream;

public class User {
    private Long cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private Long telefone;
    private String usuario;
    private String contrasena;
    private int id_rol;
    private int id_estado;

    public Long cedula() {
        return cedula;
    }

    public User setCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public User setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String apellido() {
        return apellido;
    }

    public User setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String correo() {
        return correo;
    }

    public User setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public Long telefone() {
        return telefone;
    }

    public User setTelefone(Long telefone) {
        this.telefone = telefone;
        return this;
    }

    public String usuario() {
        return usuario;
    }

    public User setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String contrasena() {
        return contrasena;
    }

    public User setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public int id_rol() {
        return id_rol;
    }

    public User setId_rol(int id_rol) {
        this.id_rol = id_rol;
        return this;
    }

    public int id_estado() {
        return id_estado;
    }

    public User setId_estado(int id_estado) {
        this.id_estado = id_estado;
        return this;
    }
    public User(Long cedula , String nombre, String apellido,String correo, Long telefono , String usuario, String contrasena, int id_rol, int id_estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefone = telefono;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.id_rol= id_rol;
        this.id_estado = id_estado;
    }


    public Long getCedula() {
        return null;
    }

    public String getNombre() {
        return null;
    }

    public String getContrasena() {
        return null;
    }

    public String getCorreo() {
        return null;
    }

    public Long getTelefono() {
        return null;
    }

    public String getDireccion() {
        return null;
    }

    public Object getIdRol() {
        return null;
    }

  

    public Object getIdestado() {
        return null;
    }
}

