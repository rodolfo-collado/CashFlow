package com.rodolfo.cashflow.infrastructure.adapters.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.domain.models.Usuario;
import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.UsuarioDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.BigDecimalConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.DateConverter;


@TypeConverters({BigDecimalConverter.class, DateConverter.class})
@Database(entities = {Transaccion.class, Usuario.class, Credenciales.class}, version = 1) // Le indica a Room cuáles son las tablas
public abstract class AppDataBase extends RoomDatabase {

    // Room genera el código automáticamente
    public abstract TransaccionDao transaccionDao();
    public abstract UsuarioDao usuarioDao();
    public abstract CredencialesDao credencialesDao();
}
