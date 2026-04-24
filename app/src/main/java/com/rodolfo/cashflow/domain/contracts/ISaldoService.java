package com.rodolfo.cashflow.domain.contracts;

import com.rodolfo.cashflow.domain.models.Gasto;
import com.rodolfo.cashflow.domain.models.Ingreso;

import java.math.BigDecimal;

public interface ISaldoService {

    void registrarGasto(Gasto gasto);

    void registrarIngreso(Ingreso ingreso);

    BigDecimal consultarSaldoActual(Integer id);
}
