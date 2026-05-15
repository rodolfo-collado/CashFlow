package com.rodolfo.cashflow.infrastructure.adapters.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.rodolfo.cashflow.domain.models.enums.EstadoUsuario;

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
@Entity(tableName = "usuarios")
public class UsuarioEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "apellido")
    private String apellido;

    @ColumnInfo(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ColumnInfo(name = "correo")
    private String correo;

    @ColumnInfo(name = "telefono")
    private String telefono;

    @ColumnInfo(name = "direccion")
    private String direccion;

    @ColumnInfo(name = "ciudad")
    private String ciudad;

    @ColumnInfo(name = "pais")
    private String pais;

    @ColumnInfo(name = "estado_usuario")
    private EstadoUsuario estadoUsuario;

    @ColumnInfo(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @ColumnInfo(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

}
