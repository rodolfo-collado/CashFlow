package com.rodolfo.cashflow.domain.models;

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
public class Credenciales {
    private Long id;
    private Long usuarioId;
    private String username;
    private String password;
    private String pin;
}
/*
A futuro con kotlin:

  private LocalDateTime ultimoAcceso;
  private Integer intentosFallidos;
  private LocalDateTime bloqueadoHasta;
  private LocalDateTime fechaUltimoCambioPassword;
  private LocalDateTime fechaUltimoCambioPin;
  private Boolean requiereCambioPassword;
  private Boolean requiereCambioPin;
 */
