package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.application.segurity.PasswordValidator;
import com.rodolfo.cashflow.application.segurity.SesionValidator;
import com.rodolfo.cashflow.application.validators.CredencialesValidator;
import com.rodolfo.cashflow.application.validators.UsuarioValidator;
import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IAuthService;
import com.rodolfo.cashflow.domain.exceptions.CredencialesInvalidasException;
import com.rodolfo.cashflow.domain.exceptions.SesionInvalidaException;
import com.rodolfo.cashflow.domain.exceptions.usuarioInvalidoException;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.util.UUID;

public class AuthService implements IAuthService {

    private Usuario usuarioActual;
    private String tokenSesionActual;
    private final ICredencialesRepository credRepo;
    private final IUsuarioRepository userRepo;
    private final PasswordValidator passwordValidator;
    private final SesionValidator sesionValidator;
    private final CredencialesValidator credencialesValidator;
    private final UsuarioValidator usuarioValidator;


    public AuthService(ICredencialesRepository credRepo, IUsuarioRepository userRepo, PasswordValidator passwordValidator, CredencialesValidator credencialesValidator, SesionValidator sesionValidator, UsuarioValidator usuarioValidator) {
        this.credRepo = credRepo;
        this.userRepo = userRepo;
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
        this.usuarioActual = usuario;
    }

    @Override
    public Usuario iniciarSesion(String username, String password) {
        credencialesValidator.validarFormatoLogin(username, password);
        Credenciales credenciales = credencialesValidator.obtenerCredencialesValidadas(username, password);
        this.usuarioActual = usuarioValidator.obtenerUsuarioValidado(credenciales);
        this.tokenSesionActual = UUID.randomUUID().toString();
        return usuarioActual;
    }

    @Override
    public void cerrarSesion() {
        this.usuarioActual = null;
        this.tokenSesionActual = null;
    }

    @Override
    public void eliminarCuenta(String password) {
        sesionValidator.validarSesion(this.usuarioActual, this.tokenSesionActual);
        passwordValidator.validarPassword(this.usuarioActual, password);
        userRepo.borrar(usuarioActual);
        cerrarSesion();

    }

    @Override
    public boolean estaAutenticado() {
        return this.usuarioActual != null;
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        return this.usuarioActual;
    }

}
