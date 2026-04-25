package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.services.ISaldoService;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.ItransacionRepository;
import com.rodolfo.cashflow.domain.exceptions.MontoInvalidoException;
import com.rodolfo.cashflow.domain.exceptions.TransferenciaInvalidaException;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;

public class FlujoDineroService implements ISaldoService {
    private final ItransacionRepository transaccionRepo;
    private final IUsuarioRepository usuarioRepo;

    public FlujoDineroService(ItransacionRepository transaccionRepo, IUsuarioRepository usuarioRepo) {
        this.transaccionRepo = transaccionRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void registrarGasto(Transaccion gasto) {
        Usuario usuario = usuarioRepo.buscarUsuario(gasto.getId());
    }

    @Override
    public void registrarTransferencia(Transaccion transferencia) {
        Usuario usuario = usuarioRepo.buscarUsuario(transferencia.getId());
    }

    @Override
    public void registrarUsuario(Usuario usuario) {

    }

    @Override
    public BigDecimal consultarSaldoActual(Integer id) {
        return null;
    }

    private void validacionTransaccionBasica(Transaccion transaccion) {
        if (transaccion == null || transaccion.getMonto() == null) {
            throw new TransferenciaInvalidaException("Transacción inválida. Debe tener un monto.");
        }
        if (transaccion.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MontoInvalidoException("Monto inválido, debe ser mayor a 0.");
        }
    }


}
