package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.EstadoCuenta;

public class EstadoCuentaConverter {
    @TypeConverter
    public String fromEstadoCuenta(EstadoCuenta value){
        return value == null ? null : value.name();
    }

    @TypeConverter
    public EstadoCuenta toEstadoCuenta(String value){
        return value == null ? null : EstadoCuenta.valueOf(value);
    }
}
