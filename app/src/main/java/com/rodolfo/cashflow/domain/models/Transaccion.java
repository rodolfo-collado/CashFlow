package com.rodolfo.cashflow.domain.models;

import com.rodolfo.cashflow.domain.models.enums.EstadoTransaccion;
import com.rodolfo.cashflow.domain.models.enums.TipoTransaccion;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    private Long id;
    private LocalDate fecha;
    private BigDecimal monto;
    private TipoTransaccion tipo;
    private EstadoTransaccion estado;
    private Long idUsuarioOrigen;
    private Long idUsuarioDestino;
    private BigDecimal saldoAnterior;
    private BigDecimal saldoPosterior;
    private String localExterno;
    private String descripcion;
}
