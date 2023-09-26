package com.example.bibliotecasena.modelos.User;

public class Login {
    private Long cedula;
    private String contrasena;

    public Login (Long cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena= contrasena;

    }

    public Long cedula() {
        return cedula;
    }

    public Login setCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public String contrasena() {
        return contrasena;
    }

    public Login setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }
}
