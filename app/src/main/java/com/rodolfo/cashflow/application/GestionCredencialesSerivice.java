package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.services.ICredencialesService;

public class GestionCredencialesSerivice implements ICredencialesService {
    private final ICredencialesRepository CredsRepo;

    public GestionCredencialesSerivice(ICredencialesRepository credsRepo) {
        CredsRepo = credsRepo;
    }

    @Override
    public void cambiarUsername(String password, String username) {

    }

    @Override
    public void cambiarContrasena(String oldPassword, String newPassword) {

    }

    @Override
    public void cambiarPin(String password, String pin) {

    }
}
