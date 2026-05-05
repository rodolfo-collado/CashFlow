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


    // Validaciones

    private void validarDatosUsuario(Usuario usuario){
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

    private void validarDatosCredenciales(String username, String password, String pin){
        if(username == null || username.isBlank()){
            throw new CredencialesInvalidasException("El usuario es obligatorio.");
        }
        if(password == null || password.isBlank()){
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }
        if(password.length() < 12){
            throw new CredencialesInvalidasException("La contraseña debe tener al menos 12 caracteres.");
        }

        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        if(!hasUppercase || !hasDigit || !hasSpecial){
            throw new CredencialesInvalidasException(
                    "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial.");
        }

        if (pin == null || !pin.matches("\\d{4}")) {
            throw new CredencialesInvalidasException("El PIN debe contener 4 digitos numericos.");
        }

    }

    private void validarUsernameDisponible(String username){
        if(credRepo.buscarPorUsername(username) != null){
            throw new CredencialesInvalidasException("El usuario ya existe.");
        }
    }

    private void validarFormatoLogin(String username, String password){
        if(username == null || username.isBlank()){
            throw new CredencialesInvalidasException("El usuario es obligatorio.");
        }
        if(password == null || password.isBlank()){
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }
    }

    private Credenciales obtenerCredencialesValidadas(String username, String password){
        Credenciales creds = credRepo.buscarPorUsername(username);

        if (creds == null) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        if (!creds.getPassword().equals(password)) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        return creds;
    }

    private Usuario obtenerUsuarioValidado(Credenciales creds){
        Usuario user = userRepo.buscarPorId(creds.getUsuarioId());

        if(user == null) {
            throw new CredencialesInvalidasException("Nombre de usuario o contraseña incorrectos.");
        }

        return user;
    }
    private void validarSesion(Usuario usuarioActual, String tokenSesionActual){
        if(usuarioActual == null || tokenSesionActual == null){
          throw new SesionInvalidaException("No hay una sesión activa válida.");
        }
    }

    private void validarPassword(String password) {
        Credenciales creds = credRepo.buscarPorId(usuarioActual.getId());

        if (password == null || password.isBlank()) {
            throw new CredencialesInvalidasException("La contraseña es obligatoria.");
        }

        if(creds == null){
            throw new CredencialesInvalidasException("Credenciales inválidas. Error inesperado.");
        }

        if(!password.equals(creds.getPassword())){
            throw new CredencialesInvalidasException("Contraseña inválida.");
        }
    }
}
