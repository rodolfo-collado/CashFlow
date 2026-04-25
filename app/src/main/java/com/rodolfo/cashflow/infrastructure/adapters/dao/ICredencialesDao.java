package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.cashflow.domain.models.Credenciales;

@Dao
public interface ICredencialesDao {


    @Insert
    void insertar(Credenciales credenciales);

    @Update
    void actualizar(Credenciales credenciales);

    @Delete
    void borrar(Integer id);
    @Query("SELECT * FROM credenciales WHERE id = :id")
    Credenciales buscarPorId(Integer id);

    @Query("SELECT * FROM credenciales WHERE username = :username")
    Credenciales buscarPorUsername(String username);

    @Query("SELECT * FROM credenciales WHERE token = :token")
    Credenciales buscarPorToken(String token);



}
