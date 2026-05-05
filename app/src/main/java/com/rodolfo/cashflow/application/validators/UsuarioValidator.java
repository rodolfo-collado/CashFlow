package com.rodolfo.cashflow.application.validators;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.exceptions.usuarioInvalidoException;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

public class UsuarioValidator {
    private final IUsuarioRepository userRepo;

    public UsuarioValidator(IUsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void validarDatosUsuario(Usuario usuario){
        if (usuario == null){
            throw new usuarioInvalidoException("El usuario es obligatorio.");
        }

        if(usuario.getNombre() == null || usuario.getNombre().isBlank()){
            throw new usuarioInvalidoException("El nombre es obligatorio.");
        }

        if(usuario.getApellido() == null || usuario.getApellido().isBlank()){
            throw new usuarioInvalidoException("El apellido es obligatorio.");
        }

        if(usuario.getCorreo() == null || usuario.getCorreo().isBlank()){
            throw new usuarioInvalidoException("El correo es obligatorio.");
        }

        if(usuario.getTelefono() == null){
            throw new usuarioInvalidoException("El teléfono es obligatorio.");
        }

        if(usuario.getDireccion() == null || usuario.getDireccion().isBlank()){
            throw new usuarioInvalidoException("La dirección es obligatoria.");
        }
    }

    public Usuario obtenerUsuarioValidado(Credenciales creds){
        Usuario user = userRepo.buscarPorId(creds.getUsuarioId());

        if(user == null) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        return user;
    }
}
