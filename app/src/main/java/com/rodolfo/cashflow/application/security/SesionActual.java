package com.rodolfo.cashflow.application.security;

import com.rodolfo.cashflow.domain.models.Usuario;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Singleton
@Getter
@AllArgsConstructor
public class SesionActual {
    private Usuario usuarioActual;
    private String tokenSesionActual;

    @Inject
    public SesionActual() {
    }


    public void iniciar(Usuario usuario) {
        String token = UUID.randomUUID().toString();
        this.usuarioActual = usuario;
        this.tokenSesionActual = token;
    }

    public void cerrar() {
        this.usuarioActual = null;
        this.tokenSesionActual = null;
    }

    public boolean isActiva() {
        return usuarioActual != null && tokenSesionActual != null;
    }
}
