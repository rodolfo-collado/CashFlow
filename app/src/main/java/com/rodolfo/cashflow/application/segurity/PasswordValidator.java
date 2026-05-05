package com.rodolfo.cashflow.application.segurity;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

public class PasswordValidator {
    private final ICredencialesRepository credRepo;

    public PasswordValidator(ICredencialesRepository credRepo) {
        this.credRepo = credRepo;
    }

    public void validarPassword(Usuario usuarioActual, String password) {
        Credenciales creds = credRepo.buscarPorId(usuarioActual.getId());

        if (password == null || password.isBlank()) {
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }

        if(creds == null){
            throw new CredencialesInvalidasException("Credenciales inválidas. Error inesperado.");
        }

        if(!password.equals(creds.getPassword())){
            throw new CredencialesInvalidasException("Contraseña inválida.");
        }
    }
}
