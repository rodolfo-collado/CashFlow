package com.rodolfo.cashflow.infrastructure.adapters.room;

import androidx.room.TypeConverter;

import java.math.BigDecimal;

public class Converters {

    @TypeConverter
    public String fromBigDecimal(BigDecimal value){
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public BigDecimal toBigDecimal(String value){
      return value == null ? null : new BigDecimal(value);
    }
}
