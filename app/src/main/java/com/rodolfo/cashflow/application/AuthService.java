package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IAuthService;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

public class AuthService implements IAuthService {

    private final ICredencialesRepository credRepo;
    private final IUsuarioRepository userRepo;

    public AuthService(ICredencialesRepository credRepo, IUsuarioRepository userRepo) {
        this.credRepo = credRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Usuario iniciarSesion(String username, String password) {
        Credenciales creds = credRepo.buscarPorUsername(username);
        if (creds != null && creds.getPassword().equals(password)) {
            return userRepo.buscarPorId(creds.getUsuarioId());

        }else return null;
    }

    @Override
    public void registrar(Usuario usuario, String username, String password) {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public boolean estaAutenticado() {
        return false;
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        return null;
    }
}
