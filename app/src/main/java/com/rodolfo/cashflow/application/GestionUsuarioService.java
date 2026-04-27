package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.services.IUsuarioService;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class GestionUsuarioService implements IUsuarioService {

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void registrar(Usuario usuario) {

    }

    @Override
    public void actualizar(Usuario usuario) {

    }

    private void validarUsuario(Usuario usuario){
        if (usuario == null){
            throw new CredencialesInvalidasException("Credenciales inválidas, debe tener un nombre de usuario y una contraseña");

        }
    }
}
