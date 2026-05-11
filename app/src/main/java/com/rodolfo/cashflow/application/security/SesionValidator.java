package com.rodolfo.cashflow.application.security;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.exceptions.SesionInvalidaException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class SesionValidator {
    private final SesionActual sesionActual;

    @Inject
    public SesionValidator(SesionActual sesionActual) {
        this.sesionActual = sesionActual;
    }

    public void validarSesion() {
        if (!sesionActual.isActiva()) {
            throw new SesionInvalidaException("No hay una sesión activa válida.");
        }
    }
}
