package com.rodolfo.cashflow.application.validators;

import javax.inject.Inject;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.exceptions.UsuarioInvalidoException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class UsuarioValidator {
    private final IUsuarioRepository userRepo;

    @Inject
    public UsuarioValidator(IUsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void validarDatosUsuario(Usuario usuario){
        if (usuario == null){
            throw new UsuarioInvalidoException("El usuario es obligatorio.");
        }

        ValidatorUnits.validarCampoObligatorio(
                usuario.getNombre(),
                "El nombre es obligatorio.",
                UsuarioInvalidoException::new
        );
        ValidatorUnits.validarCampoObligatorio(
                usuario.getApellido(),
                "El apellido es obligatorio.",
                UsuarioInvalidoException::new
        );
        ValidatorUnits.validarCampoObligatorio(
                usuario.getCorreo(),
                "El correo es obligatorio.",
                UsuarioInvalidoException::new
        );

        if(usuario.getTelefono() == null){
            throw new UsuarioInvalidoException("El teléfono es obligatorio.");
        }

        ValidatorUnits.validarCampoObligatorio(
                usuario.getDireccion(),
                "La dirección es obligatoria.",
                UsuarioInvalidoException::new
        );
    }

    public void validarFormatoUsuario(Usuario usuario){

    }
}
