package com.rodolfo.cashflow.application.validators;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.exceptions.UsuarioInvalidoException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class UsuarioValidator {

    @Inject
    public UsuarioValidator() {}

    public void validarDatosUsuario(Usuario usuario){
        validarUsuarioNoNulo(usuario);
        validarFormatoNombres(usuario.getNombre());
        validarFormatoApellidos(usuario.getApellido());
        validarFormatoCorreo(usuario.getCorreo());
        validarFormatoTelefono(usuario.getTelefono());
        validarFormatoDireccion(usuario.getDireccion());
    }

    public void validarUsuarioNoNulo(Usuario usuario){
        ValidatorUnits.validarNoNulo(usuario,
                "El usuario es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoNombres(String nombre){
        ValidatorUnits.validarCampoObligatorio(
                nombre,
                "El nombre es obligatorio.",
                UsuarioInvalidoException::new);
    }

    public void validarFormatoApellidos(String apellido){
        ValidatorUnits.validarCampoObligatorio(
                apellido,
                "El apellido es obligatorio.",
                UsuarioInvalidoException::new);
    }

    private String limpiarCorreo(String correo) {
        ValidatorUnits.validarCampoObligatorio(
                correo,
                "El correo es obligatorio.",
                UsuarioInvalidoException::new
        );
        return correo.trim();
    }

    private void validarCorreoLimpio(String correoLimpio) {
        if (!correoLimpio.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new UsuarioInvalidoException("Formato de correo inválido.");
        }
    }

    public void validarFormatoCorreo(String correo) {
        String correoLimpio = limpiarCorreo(correo);
        validarCorreoLimpio(correoLimpio);
    }

    public String normalizarCorreo(String correo) {
        String correoLimpio = limpiarCorreo(correo);
        validarCorreoLimpio(correoLimpio);
        return correoLimpio;
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
        validarFormatoTelefono(telefono);
        String telefonoLimpio = telefono.trim().replaceAll("[\\s-]", "");
        return telefonoLimpio.substring(0, 4) + "-" + telefonoLimpio.substring(4);
    }

    public void validarFormatoDireccion(String direccion){
        ValidatorUnits.validarCampoObligatorio(
                direccion,
                "La dirección es obligatoria.",
                UsuarioInvalidoException::new);

        if(direccion.trim().length() < 10){
            throw new UsuarioInvalidoException("La dirección debe tener al menos 10 caracteres.");
        }

        if (direccion.trim().length() > 120){
            throw new UsuarioInvalidoException("La dirección debe tener como máximo 120 caracteres.");
        }
    }
}
