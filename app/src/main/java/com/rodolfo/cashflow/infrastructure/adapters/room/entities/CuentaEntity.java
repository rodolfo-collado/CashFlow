package com.rodolfo.cashflow.infrastructure.adapters.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.rodolfo.cashflow.domain.models.enums.EstadoCuenta;
import com.rodolfo.cashflow.domain.models.enums.MonedaCuenta;
import com.rodolfo.cashflow.domain.models.enums.TipoCuenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(
        tableName = "cuentas",
        foreignKeys = @ForeignKey(
                entity = UsuarioEntity.class,
                parentColumns = "id",
                childColumns = "usuario_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = {"usuario_id"}, unique = true)}
)
public class CuentaEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "usuario_id")
    private Long usuarioId;

    @ColumnInfo(name = "numero_cuenta")
    private String numeroCuenta;

    @ColumnInfo(name = "moneda")
    private MonedaCuenta moneda;

    @ColumnInfo(name = "saldo_total")
    private BigDecimal saldoTotal;

    @ColumnInfo(name = "tipo_cuenta")
    private TipoCuenta tipoCuenta;

    @ColumnInfo(name = "estado")
    private EstadoCuenta estado;

    @ColumnInfo(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ColumnInfo(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}

