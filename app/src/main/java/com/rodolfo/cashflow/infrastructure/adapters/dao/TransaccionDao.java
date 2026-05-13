package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.cashflow.infrastructure.adapters.room.entities.TransaccionEntity;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface TransaccionDao {

    @Insert
    Long insertar(TransaccionEntity transaccion);

    @Update
    void actualizar(TransaccionEntity transaccion);

    @Query("DELETE FROM transacciones WHERE id = :id")
    void eliminarPorId(Long id);

    @Query("SELECT * FROM transacciones")
    List<TransaccionEntity> obtenerTodas();

    @Query("SELECT * FROM transacciones WHERE tipo = 'GASTO'")
    List<TransaccionEntity> obtenerSoloGastos();

    @Query("SELECT * FROM transacciones WHERE tipo = 'TRANSFERENCIA'")
    List<TransaccionEntity> obtenerSoloTransferencias();

    @Query("SELECT * FROM transacciones WHERE fecha = :fecha")
    List<TransaccionEntity> obtenerPorFecha(LocalDate fecha);

    @Query("SELECT * FROM transacciones WHERE fecha BETWEEN :inicio AND :fin")
    List<TransaccionEntity> obtenerRangoFechas(LocalDate inicio, LocalDate fin);
}
