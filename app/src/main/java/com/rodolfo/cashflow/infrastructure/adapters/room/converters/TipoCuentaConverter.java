package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.TipoCuenta;

public class TipoCuentaConverter {
    @TypeConverter
    public String fromTipoCuenta(TipoCuenta value){
    return value == null ? null : value.name();
    }

    @TypeConverter
    public TipoCuenta toTipoCuenta(String value){
        return value == null ? null : TipoCuenta.valueOf(value);
    }
}
