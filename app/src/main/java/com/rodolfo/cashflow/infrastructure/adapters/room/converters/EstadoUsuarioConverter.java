package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.EstadoUsuario;

public class EstadoUsuarioConverter {
    @TypeConverter
    public String fromEstadoUsuario(EstadoUsuario value){
        return value == null ? null : value.name();
    }

    @TypeConverter
    public EstadoUsuario toEstadoUsuario(String value){
        return value == null ? null : EstadoUsuario.valueOf(value);
    }
}
