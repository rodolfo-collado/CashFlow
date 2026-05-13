package com.rodolfo.cashflow.infrastructure.adapters.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CredencialesEntity;

@Dao
public interface CredencialesDao {


    @Insert
    Long insertar(CredencialesEntity credenciales);

    @Update
    void actualizar(CredencialesEntity credenciales);

    @Query("DELETE FROM credenciales WHERE usuario_id = :usuarioId")
    void borrarPorUsuarioId(Long usuarioId);

    @Query("SELECT * FROM credenciales WHERE usuario_id = :usuarioId LIMIT 1")
    CredencialesEntity buscarPorUsuarioId(Long usuarioId);

    @Query("SELECT * FROM credenciales WHERE username = :username LIMIT 1")
    CredencialesEntity buscarPorUsername(String username);

    @Query("UPDATE credenciales SET username = :username WHERE usuario_id = :usuarioId")
    void cambiarUsername(Long usuarioId, String username);

    @Query("UPDATE credenciales SET password = :password WHERE usuario_id = :usuarioId")
    void cambiarPassword(Long usuarioId, String password);

    @Query("UPDATE credenciales SET pin = :pin WHERE usuario_id = :usuarioId")
    void cambiarPin(Long usuarioId, String pin);



}
