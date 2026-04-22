package com.rodolfo.cashflow.application;

import com.rodolfo.cashflow.domain.contracts.ISaldoService;
import com.rodolfo.cashflow.domain.contracts.ItransacionRepository;
import com.rodolfo.cashflow.domain.models.Transaccion;

import java.math.BigDecimal;

public class CashFlowServiceImpl implements ISaldoService {
    private ItransacionRepository repository;

    public CashFlowServiceImpl(ItransacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registrarMovimiento(Transaccion transaccion) {
        
    }

    @Override
    public BigDecimal consultarSaldoActual(Integer id) {
        return null;
    }
}
