package com.rodolfo.cashflow.application;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.application.security.PasswordValidator;
import com.rodolfo.cashflow.application.security.SesionActual;
import com.rodolfo.cashflow.application.security.SesionValidator;
import com.rodolfo.cashflow.application.validators.CredencialesValidator;
import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.services.ICredencialesService;

@Singleton
public class GestionCredencialesService implements ICredencialesService {

    private final SesionActual sesionActual;
    private final ICredencialesRepository CredsRepo;
    private final PasswordValidator passwordValidator;
    private final CredencialesValidator credencialesValidator;
    private final SesionValidator sesionValidator;

    @Inject
    public GestionCredencialesService(SesionActual sesionActual, ICredencialesRepository credsRepo, PasswordValidator passwordValidator, CredencialesValidator credencialesValidator, SesionValidator sesionValidator) {
        this.sesionActual = sesionActual;
        this.CredsRepo = credsRepo;
        this.passwordValidator = passwordValidator;
        this.credencialesValidator = credencialesValidator;
        this.sesionValidator = sesionValidator;
    }

    @Override
    public void cambiarUsername(String password, String username) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        credencialesValidator.validarUsernameDisponible(username);
        CredsRepo.cambiarUsername(sesionActual.getUsuarioActual().getId(), username);
    }

    @Override
    public void cambiarPassword(String oldPassword, String newPassword) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), oldPassword);
        CredsRepo.cambiarPassword(sesionActual.getUsuarioActual().getId(), newPassword);
    }

    @Override
    public void cambiarPin(String password, String pin) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        CredsRepo.cambiarPin(sesionActual.getUsuarioActual().getId(), pin);
    }
}
