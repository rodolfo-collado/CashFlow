package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.cashflow.domain.models.Usuario;

import java.math.BigDecimal;
import java.util.List;

@Dao
public interface UsuarioDao {

    @Insert
    void insertar(Usuario usuario);

    @Update
    void actualizar(Usuario usuario);

    @Delete
    void borrar(Usuario usuario);

    @Query("DELETE FROM usuarios WHERE id = :id")
    void borrarPorId(Integer id);

    @Query("SELECT * FROM usuarios WHERE id = :id")
    Usuario obtenerUsuarioPorId(Integer id);

    @Query("SELECT saldo_Total FROM usuarios WHERE id = :id")
    BigDecimal obtenerSaldoPorId(Integer id);

    @Query("SELECT * FROM usuarios")
    List<Usuario> obtenerTodos();

}
