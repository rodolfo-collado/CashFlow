package com.rodolfo.cashflow.infrastructure.adapters.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.UsuarioDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.BigDecimalConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.DateConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.EstadoCuentaConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.EstadoTransaccionConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.EstadoUsuarioConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.MonedaCuentaConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.TipoCuentaConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.converters.TipoTransaccionConverter;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CredencialesEntity;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.TransaccionEntity;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.UsuarioEntity;


@TypeConverters({
        BigDecimalConverter.class,
        DateConverter.class,
        EstadoCuentaConverter.class,
        EstadoTransaccionConverter.class,
        EstadoUsuarioConverter.class,
        MonedaCuentaConverter.class,
        TipoCuentaConverter.class,
        TipoTransaccionConverter.class
})

@Database(entities = {
        TransaccionEntity.class,
        UsuarioEntity.class,
        CredencialesEntity.class},
        version = 1
)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TransaccionDao transaccionDao();
    public abstract UsuarioDao usuarioDao();
    public abstract CredencialesDao credencialesDao();
}
