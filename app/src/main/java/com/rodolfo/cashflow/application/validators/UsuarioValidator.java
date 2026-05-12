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

    public void validarFormatoCorreo(String correo){
        ValidatorUnits.validarCampoObligatorio(
                correo,
                "El correo es obligatorio.",
                UsuarioInvalidoException::new);

        String correoLimpio = correo.trim();

        if(!correoLimpio.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new UsuarioInvalidoException("Formato de correo inválido.");
        }
    }

    public void validarFormatoTelefono(String telefono){
        ValidatorUnits.validarCampoObligatorio(
                telefono,
                "El teléfono es obligatorio.",
                UsuarioInvalidoException::new);

        String telefonoLimpio = telefono.trim();

        if (!telefonoLimpio.matches("^\\d{4}[-\\s]?\\d{4}$")) {
            throw new UsuarioInvalidoException("Formato de teléfono inválido.");
        }
    }

    public String normalizarTelefono(String telefono) {
        String telefonoLimpio = telefono.trim().replaceAll("[\\s-]", "");
        return telefonoLimpio.substring(0, 4) + "-" + telefonoLimpio.substring(4);
    }

    public void validarFormatoDireccion(String direccion){
        ValidatorUnits.validarCampoObligatorio(
                usuario.getDireccion(),
                "La dirección es obligatoria.",
                UsuarioInvalidoException::new);
    }
}
