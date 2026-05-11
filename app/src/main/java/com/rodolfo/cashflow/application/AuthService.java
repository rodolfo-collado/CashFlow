package com.rodolfo.cashflow.application;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.application.security.LoginValidator;
import com.rodolfo.cashflow.application.security.PasswordValidator;
import com.rodolfo.cashflow.application.security.SesionActual;
import com.rodolfo.cashflow.application.security.SesionValidator;
import com.rodolfo.cashflow.application.validators.CredencialesValidator;
import com.rodolfo.cashflow.application.validators.UsuarioValidator;
import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IAuthService;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.util.UUID;

@Singleton
public class AuthService implements IAuthService {

    private final SesionActual sesionActual;
    private final ICredencialesRepository credRepo;
    private final IUsuarioRepository userRepo;
    private final LoginValidator loginValidator;
    private final PasswordValidator passwordValidator;
    private final SesionValidator sesionValidator;
    private final CredencialesValidator credencialesValidator;
    private final UsuarioValidator usuarioValidator;


    @Inject
    public AuthService(SesionActual sesionActual,
                       ICredencialesRepository credRepo, IUsuarioRepository userRepo, LoginValidator loginValidator, PasswordValidator passwordValidator, CredencialesValidator credencialesValidator, SesionValidator sesionValidator, UsuarioValidator usuarioValidator) {
        this.sesionActual = sesionActual;
        this.credRepo = credRepo;
        this.userRepo = userRepo;
        this.loginValidator = loginValidator;
        this.passwordValidator = passwordValidator;
        this.credencialesValidator = credencialesValidator;
        this.sesionValidator = sesionValidator;
        this.usuarioValidator = usuarioValidator;
    }

    @Override
    public void registrar(Usuario usuario, String username, String password, String pin) {
        usuarioValidator.validarDatosUsuario(usuario); //TODO hacer la validacion del telefono
        credencialesValidator.validarDatosCredenciales(username, password, pin);
        credencialesValidator.validarUsernameDisponible(username);

        Long usuarioId = userRepo.insertar(usuario);
        Credenciales credenciales = new Credenciales(usuarioId, username, password, pin);
        credRepo.insertar(credenciales);
        sesionActual.iniciar(usuario);
    }

    @Override
    public Usuario iniciarSesion(String username, String password) {
        credencialesValidator.validarFormatoLogin(username, password);
        Credenciales credenciales = loginValidator.obtenerCredencialesValidadas(username, password);
        Usuario usuario = loginValidator.obtenerUsuarioValidado(credenciales);
        sesionActual.iniciar(usuario);
        return usuario;
    }

    @Override
    public void cerrarSesion() {
        sesionActual.cerrar();
    }

    @Override
    public void eliminarCuenta(String password) {
        sesionValidator.validarSesion(sesionActual.getUsuarioActual(), sesionActual.getTokenSesionActual());
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        userRepo.borrar(sesionActual.getUsuarioActual());
        cerrarSesion();
    }

    @Override
    public boolean estaAutenticado() {
        return sesionActual.isActiva();
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        return sesionActual.getUsuarioActual();
    }

}
