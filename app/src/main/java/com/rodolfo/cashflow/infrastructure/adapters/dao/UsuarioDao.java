package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import androidx.room.Query;
import androidx.room.Update;


import com.rodolfo.cashflow.infrastructure.adapters.room.entities.UsuarioEntity;

import java.math.BigDecimal;
import java.util.List;

@Dao
public interface UsuarioDao {

    @Insert
    Long insertar(UsuarioEntity usuario);

    @Update
    void actualizar(UsuarioEntity usuario);

    @Delete
    void borrar(UsuarioEntity usuario);

    @Query("DELETE FROM usuarios WHERE id = :id")
    void borrarPorId(Long id);

    @Query("SELECT * FROM usuarios WHERE id = :id")
    UsuarioEntity obtenerUsuarioPorId(Long id);

    @Query("SELECT saldo_Total FROM usuarios WHERE id = :id")
    BigDecimal obtenerSaldoPorId(Long id);

    @Query("SELECT * FROM usuarios")
    List<UsuarioEntity> obtenerTodos();

}
