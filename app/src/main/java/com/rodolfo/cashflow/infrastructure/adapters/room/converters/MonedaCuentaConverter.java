package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import com.rodolfo.cashflow.domain.models.enums.MonedaCuenta;


public class MonedaCuentaConverter {
    @TypeConverter
    public String fromMonedaCuenta(MonedaCuenta value){
        return value == null ? null : value.name();
    }

    @TypeConverter
    public MonedaCuenta toMonedaCuenta(String value){
        return value == null ? null : MonedaCuenta.valueOf(value);
    }
}
