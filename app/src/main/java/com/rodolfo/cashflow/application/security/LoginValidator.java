package com.rodolfo.cashflow.application.security;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

public class LoginValidator {
    private final ICredencialesRepository credRepo;
    private final IUsuarioRepository userRepo;

    @Inject
    public LoginValidator(ICredencialesRepository credRepo, IUsuarioRepository userRepo) {
        this.credRepo = credRepo;
        this.userRepo = userRepo;
    }

    public Credenciales obtenerCredencialesValidadas(String username, String password){
        Credenciales creds = credRepo.buscarPorUsername(username);

        if (creds == null) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        if (!creds.getPassword().equals(password)) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        return creds;
    }

    public Usuario obtenerUsuarioValidado(Credenciales creds){
        Usuario user = userRepo.buscarPorId(creds.getUsuarioId());

        if(user == null) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        return user;
    }
}
