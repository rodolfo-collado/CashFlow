package com.rodolfo.cashflow.infrastructure.adapters.room.converters;

import androidx.room.TypeConverter;

import java.time.LocalDate;

public class DateConverter {
    @TypeConverter
    public String fromLocalDate(LocalDate value){
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public LocalDate toLocalDate(String value){
        return value == null ? null : LocalDate.parse(value);
    }
}
