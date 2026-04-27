package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IAuthService {

    Usuario iniciarSesion(String username, String password);

    void registrar(Usuario usuario, String username, String password);

    void cerrarSesion();

    boolean estaAutenticado();

    Usuario obtenerUsuarioActual();
}
