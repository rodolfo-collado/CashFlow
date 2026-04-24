package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.ISaldoService;
import com.rodolfo.cashflow.domain.contracts.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.ItransacionRepository;
import com.rodolfo.cashflow.domain.models.Gasto;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashFlowServiceImpl implements ISaldoService {
    private final ItransacionRepository transaccionRepo;
    private final IUsuarioRepository usuarioRepo;

    public CashFlowServiceImpl( ItransacionRepository transaccionRepo, IUsuarioRepository usuarioRepo) {
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

    private void validacionTransaccionBasica(Transaccion transaccion){
        if (transaccion == null || transaccion.getMonto() == null) {
            throw new IllegalArgumentException("Datos incompletos.");
        }
        if (transaccion.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0.");
        }
        if (transaccion.getDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha inválida.");
        }


    }


}
