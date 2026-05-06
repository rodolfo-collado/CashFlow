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
        validarFormatoLogin(username, password);
        validarFormatoUsername(username);
        validarFormatoPassword(password);
        validarFormatoPin(pin);

    }

    public void validarFormatoLogin(String username, String password){
        ValidatorUnits.validarCampoObligatorio(
                username,
                "El usuario es obligatorio.",
                CredencialesInvalidasException::new
        );
        ValidatorUnits.validarCampoObligatorio(
                password,
                "La contraseña es obligatoria.",
                CredencialesInvalidasException::new
        );

    }

    public void validarFormatoUsername(String username){
        ValidatorUnits.validarCampoObligatorio(
                username,
                "El usuario es obligatorio.",
                CredencialesInvalidasException::new
        );

        if(username.matches(".*[!@#$%^&*(),.?\":{}|<>].*")){
            throw new CredencialesInvalidasException("USuario inválido.");
        }
        if(username.length() < 8){
            throw new CredencialesInvalidasException("Mínimo 8 caracteres.");
        }
        if(username.length() > 40){
            throw new CredencialesInvalidasException("Máximo 40 caracteres.");
        }
    }

    public void validarFormatoPassword(String password){
        ValidatorUnits.validarCampoObligatorio(
                password,
                "La contraseña es obligatoria.",
                CredencialesInvalidasException::new
        );

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
    }

    public void validarFormatoPin(String pin){
        if (pin == null || !pin.matches("\\d{4}")) {
            throw new CredencialesInvalidasException("El PIN debe contener 4 digitos numericos.");
        }
    }

    public void validarUsernameDisponible(String username){
        if(credRepo.buscarPorUsername(username) != null){
            throw new CredencialesInvalidasException("El usuario ya existe.");
        }
    }





}
