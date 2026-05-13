package com.rodolfo.cashflow.domain.models;

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
    private LocalDate date = LocalDate.now();
    private BigDecimal monto;
    private String tipo;
    private Long idUsuarioOrigen;
    private Long idUsuarioDestino;
    private String localExterno;
    private String descripcion;


    protected Transaccion(BigDecimal monto,
                          String tipo,
                          Long idUsuarioOrigen,
                          Long idUsuarioDestino,
                          String localExterno,
                          String descripcion) {

        this.monto = monto;
        this.tipo = tipo;
        this.idUsuarioOrigen = idUsuarioOrigen;
        this.idUsuarioDestino = idUsuarioDestino;
        this.localExterno = localExterno;
        this.descripcion = descripcion;
        this.date = LocalDate.now();
    }

}
