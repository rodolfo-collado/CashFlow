package com.rodolfo.cashflow.application;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.application.security.PasswordValidator;
import com.rodolfo.cashflow.application.security.SesionActual;
import com.rodolfo.cashflow.application.security.SesionValidator;
import com.rodolfo.cashflow.application.validators.UsuarioValidator;
import com.rodolfo.cashflow.application.validators.ValidatorUnits;
import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.IUsuarioService;
import com.rodolfo.cashflow.domain.exceptions.CambioInvalidoException;

@Singleton
public class GestionUsuarioService implements IUsuarioService {
    private final SesionActual sesionActual;
    private final IUsuarioRepository userRepo;
    private final UsuarioValidator usuarioValidator;
    private final SesionValidator sesionValidator;
    private final PasswordValidator passwordValidator;

    @Inject
    public GestionUsuarioService(SesionActual sesionActual, ICredencialesRepository credRepo, IUsuarioRepository userRepo, UsuarioValidator usuarioValidator, SesionValidator sesionValidator, PasswordValidator passwordValidator) {
        this.sesionActual = sesionActual;
        this.userRepo = userRepo;
        this.usuarioValidator = usuarioValidator;
        this.sesionValidator = sesionValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public void cambiarCorreo(String password, String correo) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        usuarioValidator.validarFormatoCorreo(correo);

        String correoNormalizado = usuarioValidator.normalizarCorreo(correo);

        ValidatorUnits.validarCamposDiferentes(
                sesionActual.getUsuarioActual().getCorreo(),
                correoNormalizado,
                "Correo nuevo inválido",
                CambioInvalidoException::new
        );

        sesionActual.getUsuarioActual().setCorreo(correoNormalizado);
        userRepo.actualizar(sesionActual.getUsuarioActual());

    }

    @Override
    public void cambiarTelefono(String password, String telefono) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        usuarioValidator.validarFormatoTelefono(telefono);

        String telefonoNormalizado = usuarioValidator.normalizarTelefono(telefono);

        ValidatorUnits.validarCamposDiferentes(
                sesionActual.getUsuarioActual().getTelefono(),
                telefonoNormalizado,
                "Teléfono nuevo inválido",
                CambioInvalidoException::new
        );

        sesionActual.getUsuarioActual().setTelefono(telefonoNormalizado);
        userRepo.actualizar(sesionActual.getUsuarioActual());
    }

    @Override
    public void cambiarDireccion(String password, String direccion) {
        sesionValidator.validarSesion();
        passwordValidator.validarPassword(sesionActual.getUsuarioActual(), password);
        usuarioValidator.validarFormatoDireccion(direccion);

        ValidatorUnits.validarCamposDiferentes(
                sesionActual.getUsuarioActual().getDireccion(),
                direccion,
                "Dirección nueva inválida",
                CambioInvalidoException::new
        );

        sesionActual.getUsuarioActual().setDireccion(direccion);
        userRepo.actualizar(sesionActual.getUsuarioActual());
    }

}
