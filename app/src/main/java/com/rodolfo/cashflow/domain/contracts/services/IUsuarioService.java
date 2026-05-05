package com.rodolfo.cashflow.domain.contracts.services;

public interface IUsuarioService {


    void cambiarCorreo(String password, String correo);

    void cambiarTelefono(String password, Integer telefono);

    void cambiarDireccion(String password, String direccion);
}
