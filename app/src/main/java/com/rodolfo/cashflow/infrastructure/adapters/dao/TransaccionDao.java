package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.cashflow.domain.models.Transaccion;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface TransaccionDao {

    @Insert
    void insertar(Transaccion transaccion);

    @Update
    void actualizar(Transaccion transaccion);

    @Query("DELETE FROM transacciones WHERE id = :id")
    void eliminarPorId(Integer id);

    @Query("SELECT * FROM transacciones")
    List<Transaccion> obtenerTodas();

    @Query("SELECT * FROM transacciones WHERE tipo = 'GASTO'")
    List<Transaccion> obtenerSoloGastos();

    @Query("SELECT * FROM transacciones WHERE tipo = 'TRANSFERENCIA'")
    List<Transaccion> obtenerSoloTransferencias();

    @Query("SELECT * FROM transacciones WHERE fecha = :fecha")
    List<Transaccion> obtenerPorFecha(LocalDate fecha);

    @Query("SELECT * FROM transacciones WHERE fecha BETWEEN :inicio AND :fin")
    List<Transaccion> obtenerRangoFechas(LocalDate inicio, LocalDate fin);
}
