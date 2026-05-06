package com.rodolfo.cashflow.application.security;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.exceptions.SesionInvalidaException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class SesionValidator {

    @Inject
    public SesionValidator() {
    }

    public void validarSesion(Usuario usuarioActual, String tokenSesionActual){
        if(usuarioActual == null || tokenSesionActual == null){
            throw new SesionInvalidaException("No hay una sesión activa válida.");
        }
    }
}
