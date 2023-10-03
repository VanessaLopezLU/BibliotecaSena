package com.example.bibliotecasena.modelos.User;

public class LoginDto {
    private Long cedula;
    private String contrasena;

    public Long cedula() {
        return cedula;
    }

    public LoginDto setCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public String contrasena() {
        return contrasena;
    }

    public LoginDto setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }
}
