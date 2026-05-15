package com.rodolfo.cashflow.infrastructure.adapters.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.rodolfo.cashflow.domain.models.enums.EstadoTransaccion;
import com.rodolfo.cashflow.domain.models.enums.TipoTransaccion;

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
                        entity = UsuarioEntity.class,
                        parentColumns = "id",
                        childColumns = "id_usuario_origen",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = UsuarioEntity.class,
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
public class TransaccionEntity {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "fecha")
    private LocalDate fecha;

    @ColumnInfo(name = "monto")
    private BigDecimal monto;

    @ColumnInfo(name = "tipo")
    private TipoTransaccion tipo;

    @ColumnInfo(name = "estado")
    private EstadoTransaccion estado;

    @ColumnInfo(name = "id_usuario_origen")
    private Long idUsuarioOrigen;

    @ColumnInfo(name = "id_usuario_destino")
    private Long idUsuarioDestino;

    @ColumnInfo(name = "saldo_anterior")
    private BigDecimal saldoAnterior;

    @ColumnInfo(name = "saldo_posterior")
    private BigDecimal saldoPosterior;

    @ColumnInfo(name = "local_externo")
    private String localExterno;

    @ColumnInfo(name = "descripcion")
    private String descripcion;
}
