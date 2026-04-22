package com.rodolfo.cashflow.domain.contracts;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.math.BigDecimal;

public interface ISaldoService {

    void registrarMovimiento(Transaccion transaccion);
    BigDecimal consultarSaldoActual(Integer id);
}
