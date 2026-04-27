package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.math.BigDecimal;

public interface ISaldoService {

    void registrarGasto(Transaccion gasto);

    void registrarTransaccion(Transaccion transferencia);

    BigDecimal consultarSaldoActual(Integer id);
}
