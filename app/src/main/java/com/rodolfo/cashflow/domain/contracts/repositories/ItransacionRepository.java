package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.util.List;

public interface ItransacionRepository {

    void guardar(Transaccion transaccion); // guarda ingreso o gasto

    List<Transaccion> obtenerTodas(); // Mostrar el Historial en el RecycleView

    List<Transaccion> obtenerGastos();

    List<Transaccion> obtenerTransferencias();

    void borrar(int id); // borrar errores (opcional)

}
