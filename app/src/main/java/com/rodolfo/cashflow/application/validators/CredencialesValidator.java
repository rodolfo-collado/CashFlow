package com.rodolfo.cashflow.application.validators;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

public class CredencialesValidator {
    private final ICredencialesRepository credRepo;

    public CredencialesValidator(ICredencialesRepository credRepo) {
        this.credRepo = credRepo;
    }

    public void validarDatosCredenciales(String username, String password, String pin){
        if(username == null || username.isBlank()){
            throw new CredencialesInvalidasException("El usuario es obligatorio.");
        }
        if(password == null || password.isBlank()){
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }
        if(password.length() < 12){
            throw new CredencialesInvalidasException("La contraseña debe tener al menos 12 caracteres.");
        }

        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        if(!hasUppercase || !hasDigit || !hasSpecial){
            throw new CredencialesInvalidasException(
                    "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial.");
        }

        if (pin == null || !pin.matches("\\d{4}")) {
            throw new CredencialesInvalidasException("El PIN debe contener 4 digitos numericos.");
        }

    }

    public void validarUsernameDisponible(String username){
        if(credRepo.buscarPorUsername(username) != null){
            throw new CredencialesInvalidasException("El usuario ya existe.");
        }
    }

    public void validarFormatoLogin(String username, String password){
        if(username == null || username.isBlank()){
            throw new CredencialesInvalidasException("El usuario es obligatorio.");
        }
        if(password == null || password.isBlank()){
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }
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


}
