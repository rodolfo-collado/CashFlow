package com.rodolfo.cashflow.application.validators;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.exceptions.UsuarioInvalidoException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class UsuarioValidator {

    @Inject
    public UsuarioValidator() {}

    public void validarDatosUsuario(Usuario usuario){
        validarUsuarioNoNulo(usuario);
        validarFormatoNombres(usuario);
        validarFormatoApellidos(usuario);
        validarFormatoCorreo(usuario);
        validarFormatoTelefono(usuario);
        validarFormatoDireccion(usuario);
    }

    public void validarUsuarioNoNulo(Usuario usuario){
        ValidatorUnits.validarNoNulo(usuario,
                "El usuario es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoNombres(Usuario usuario){
        ValidatorUnits.validarCampoObligatorio(
                usuario.getNombre(),
                "El nombre es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoApellidos(Usuario usuario){
        ValidatorUnits.validarCampoObligatorio(
                usuario.getApellido(),
                "El apellido es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoCorreo(Usuario usuario){
        ValidatorUnits.validarCampoObligatorio(usuario.getCorreo(),
                "El correo es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoTelefono(Usuario usuario){
        ValidatorUnits.validarCampoObligatorio(usuario.getTelefono(),
                "El teléfono es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoDireccion(Usuario usuario){
        ValidatorUnits.validarCampoObligatorio(
                usuario.getDireccion(),
                "La dirección es obligatoria.",
                UsuarioInvalidoException::new);
    }
}
