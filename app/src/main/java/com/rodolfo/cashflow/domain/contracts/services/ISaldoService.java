package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;

public interface ISaldoService {

    void registrarGasto(Transaccion gasto);

    void registrarTransferencia(Transaccion transferencia);

    void registrarUsuario(Usuario usuario);

    BigDecimal consultarSaldoActual(Integer id);
}
