package com.rodolfo.cashflow.domain.models;

import com.rodolfo.cashflow.domain.models.enums.EstadoCuenta;
import com.rodolfo.cashflow.domain.models.enums.MonedaCuenta;
import com.rodolfo.cashflow.domain.models.enums.TipoCuenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    private Long id;
    private Long usuarioId;
    private String numeroCuenta;
    private MonedaCuenta moneda;
    private BigDecimal saldoTotal;
    private TipoCuenta tipoCuenta;
    private EstadoCuenta estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
