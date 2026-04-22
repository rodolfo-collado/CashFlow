package com.rodolfo.cashflow.infrastructure.adapters;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;

@TypeConverters(Converters.class)
@Database(entities = {Transaccion.class, Usuario.class}, version = 1) // Le indica a Room cuáles son las tablas
public abstract class AppDataBase extends RoomDatabase {

    // Room genera el código automáticamenteTy
    public abstract TransaccionDao transaccionDao();
    public abstract UsuarioDao usuarioDao();
}
