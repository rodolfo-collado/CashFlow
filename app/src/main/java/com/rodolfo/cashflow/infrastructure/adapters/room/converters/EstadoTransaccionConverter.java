package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.EstadoTransaccion;

public class EstadoTransaccionConverter {
    @TypeConverter
    public String fromEstadoTransaccion(EstadoTransaccion value){
        return value == null ? null : value.name();
    }

    @TypeConverter
    public EstadoTransaccion toEstadoTransaccion(String value){
        return value == null ? null : EstadoTransaccion.valueOf(value);
    }
}
