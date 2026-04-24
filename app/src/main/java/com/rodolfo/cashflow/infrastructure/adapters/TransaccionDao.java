package com.rodolfo.cashflow.infrastructure.adapters;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.util.List;

@Dao
public interface TransaccionDao {

    @Insert
    void insertar(Transaccion transaccion);

    @Query("SELECT * FROM transacciones")
    List<Transaccion> obtenerTodos();

    @Query("DELETE FROM transacciones WHERE id = :id")
    void eliminarPorId(Integer id);

    @Query("SELECT * FROM transacciones WHERE tipo = 'GASTO'")
    List<Transaccion> obtenerSoloGastos();

    @Query("SELECT * FROM transacciones WHERE tipo = 'INGRESO'")
    List<Transaccion> obtenerSoloIngresos();
}
