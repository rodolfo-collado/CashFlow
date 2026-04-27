package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.services.ISaldoService;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.ITransaccionRepository;
import com.rodolfo.cashflow.domain.exceptions.MontoInvalidoException;
import com.rodolfo.cashflow.domain.exceptions.TransferenciaInvalidaException;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;

public class FlujoDineroService implements ISaldoService {
    private final ITransaccionRepository transaccionRepo;
    private final IUsuarioRepository usuarioRepo;

    public FlujoDineroService(ITransaccionRepository transaccionRepo, IUsuarioRepository usuarioRepo) {
        this.transaccionRepo = transaccionRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void registrarGasto(Transaccion gasto) {
        Usuario usuarioOrigen = usuarioRepo.buscarUsuario(gasto.getIdUsuarioOrigen());
    }

    @Override
    public void registrarTransferencia(Transaccion transferencia) {
        Usuario usuarioOrigen = usuarioRepo.buscarUsuario(transferencia.getIdUsuarioOrigen());
        Usuario usuarioDestino = usuarioRepo.buscarUsuario(transferencia.getIdUsuarioDestino());
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
