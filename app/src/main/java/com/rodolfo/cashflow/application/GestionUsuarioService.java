package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IUsuarioService;
import com.rodolfo.cashflow.domain.exceptions.UsuarioNoEncontradoException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class GestionUsuarioService implements IUsuarioService {

    private final IUsuarioRepository userRepo;

    public GestionUsuarioService(IUsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void cambiarCorreo(String password, String correo) {

    }

    @Override
    public void cambiarTelefono(String password, Integer telefono) {

    }

    @Override
    public void cambiarDireccion(String password, String direccion) {

    }


    private void validarUsuario(Usuario usuario){
        if (usuario == null){
            throw new UsuarioNoEncontradoException("Ingrese un usuario válido");
        }
    }
}
