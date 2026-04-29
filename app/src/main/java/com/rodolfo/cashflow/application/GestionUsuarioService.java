package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IUsuarioService;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.exceptions.UsuarioNoEncontradoException;
import com.rodolfo.cashflow.domain.models.Usuario;

public class GestionUsuarioService implements IUsuarioService {

    private final IUsuarioRepository userRepo;

    public GestionUsuarioService(IUsuarioRepository userRepo, ICredencialesRepository credRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registrar(Usuario usuario) {
        validarUsuario(usuario);
        userRepo.insertar(usuario);
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = userRepo.buscarPorId(id);
        if(usuario != null){
            userRepo.borrar(usuario);
        }


    }

    @Override
    public void actualizar(Usuario usuario) {
        validarUsuario(usuario);
        userRepo.actualizar(usuario);
    }

    private void validarUsuario(Usuario usuario){
        if (usuario == null){
            throw new UsuarioNoEncontradoException("Ingrese un usuario válido");
        }
    }
}
