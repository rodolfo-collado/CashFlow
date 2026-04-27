package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.time.LocalDate;
import java.util.List;

public interface ITransaccionRepository {

    Long insertar(Transaccion transaccion);

    void actualizar(Transaccion transaccion);

    void borrarPorId(Long id);

    List<Transaccion> obtenerGastos();

    List<Transaccion> obtenerTransferencias();

    List<Transaccion> obtenerTodas();

    List<Transaccion> obtenerPorFecha(LocalDate fecha);

    List<Transaccion> obtenerRangoFecha(LocalDate inicio, LocalDate fin);





}
