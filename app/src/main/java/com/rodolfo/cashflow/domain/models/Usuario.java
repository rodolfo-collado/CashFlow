package com.rodolfo.cashflow.domain.models;

import com.rodolfo.cashflow.domain.models.enums.EstadoUsuario;
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
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String pais;
    private EstadoUsuario estadoUsuario;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
}
