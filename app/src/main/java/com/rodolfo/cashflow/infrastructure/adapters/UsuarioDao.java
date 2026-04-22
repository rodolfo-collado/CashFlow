package com.rodolfo.cashflow.infrastructure.adapters;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rodolfo.cashflow.domain.models.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Insert
    void insertar(Usuario usuario);

    @Query("SELECT * FROM usuarios")
    List<Usuario> obtenerTodos();
}
