package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IAuthService;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
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
        if (creds == null || !creds.getPassword().equals(password)) { //TODO separar validaciones en un metodo a parte (o clase a parte)
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        Usuario user = userRepo.buscarPorId(creds.getUsuarioId());

        if(user == null) {
            throw new CredencialesInvalidasException("El usuario vinculado a estas credenciales no existe");
        }

        return user;
    }

    @Override
    public void registrar(Usuario usuario, String username, String password) {
        Credenciales creds = new Credenciales();
        creds.setUsername(username);
        creds.setPassword(password);
        creds.setUsuarioId(userRepo.insertar(usuario)); //TODO crear token de inicio de sesión (credenciales) con JWT
        credRepo.insertar(creds); // TODO crear token con UUID para las transacciones
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
