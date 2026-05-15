package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.TipoTransaccion;

public class TipoTransaccionConverter {
    @TypeConverter
    public String fromTipoTransaccion(TipoTransaccion value) {
        return value == null ? null : value.name();
    }

    @TypeConverter
    public TipoTransaccion toTipoTransaccion(String value) {
        return value == null ? null : TipoTransaccion.valueOf(value);
    }
}
