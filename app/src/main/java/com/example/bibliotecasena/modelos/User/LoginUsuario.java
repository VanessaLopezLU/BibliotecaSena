package com.example.bibliotecasena.modelos.User;

public class LoginUsuario {
    private Long cedula;
    private String contrasena;

    public Long cedula() {
        return cedula;
    }

    public LoginUsuario setCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public String contrasena() {
        return contrasena;
    }

    public LoginUsuario setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public LoginUsuario(Long cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena = contrasena;
    }
}
