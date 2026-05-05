package com.rodolfo.cashflow.application.segurity;

import com.rodolfo.cashflow.domain.exceptions.SesionInvalidaException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class SesionValidator {

    public void validarSesion(Usuario usuarioActual, String tokenSesionActual){
        if(usuarioActual == null || tokenSesionActual == null){
            throw new SesionInvalidaException("No hay una sesión activa válida.");
        }
    }
}
