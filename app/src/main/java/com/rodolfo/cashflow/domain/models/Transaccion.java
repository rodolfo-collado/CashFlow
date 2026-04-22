package com.rodolfo.cashflow.domain.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(tableName = "transacciones")
public abstract class Transaccion {

    @PrimaryKey(autoGenerate = true)
    protected Integer id;

    @ColumnInfo(name = "monto")
    protected BigDecimal monto;

    @ColumnInfo(name = "descripcion")
    protected String descricion;

    @ColumnInfo(name = "fecha")
    protected LocalDate date;

    @ColumnInfo(name = "tipo")
    protected String tipo;


    public abstract String getDetails();
}
