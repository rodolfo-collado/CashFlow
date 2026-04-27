package com.rodolfo.cashflow.domain.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(
        tableName = "transacciones",
        foreignKeys = {
                @ForeignKey(
                        entity = Usuario.class,
                        parentColumns = "id",
                        childColumns = "id_usuario_origen",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Usuario.class,
                        parentColumns = "id",
                        childColumns = "id_usuario_destino",
                        onDelete = ForeignKey.SET_NULL
                )
        },
        indices = {
                @Index("id_usuario_origen"),
                @Index("id_usuario_destino"),
                @Index("fecha")
        }
)
public class Transaccion {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "fecha")
    private LocalDate date;

    @ColumnInfo(name = "monto")
    private BigDecimal monto;

    @ColumnInfo(name = "tipo")
    private String tipo;

    @ColumnInfo(name = "id_usuario_origen")
    private Integer idUsuarioOrigen;

    @ColumnInfo(name = "id_usuario_destino")
    private Integer idUsuarioDestino;

    @ColumnInfo(name = "local_externo")
    private String localExterno;

    @ColumnInfo(name = "descripcion")
    private String descripcion;


    protected Transaccion(BigDecimal monto,
                          String tipo,
                          Integer idUsuarioOrigen,
                          Integer idUsuarioDestino,
                          String localExterno,
                          String descripcion) {

        this.monto = monto;
        this.tipo = tipo;
        this.idUsuarioOrigen = idUsuarioOrigen;
        this.idUsuarioDestino = idUsuarioDestino;
        this.localExterno = localExterno;
        this.descripcion = descripcion;
        this.date = LocalDate.now();
    }

}
