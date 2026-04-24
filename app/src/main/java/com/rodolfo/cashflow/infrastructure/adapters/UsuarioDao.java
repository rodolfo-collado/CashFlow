package com.rodolfo.cashflow.infrastructure.adapters;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;
import java.util.List;

@Dao
public interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertar(Usuario usuario);

    @Query("SELECT * FROM usuarios")
    List<Usuario> obtenerTodos();

    @Query("DELETE FROM usuarios WHERE id = :id")
    void eliminarPorId(Integer id);

    @Query("SELECT * FROM usuarios WHERE id = :id")
    Usuario obtenerUsuarioPorId(Integer id);

    @Query("SELECT saldo_Total FROM usuarios WHERE id = :id")
    BigDecimal obtenerSaldoPorId(Integer id);



}
