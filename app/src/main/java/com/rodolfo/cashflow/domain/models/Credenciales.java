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

    public Credenciales(Long usuarioId, String username, String password, String pin){
        this.id = null;
        this.usuarioId = usuarioId;
        this.username = username;
        this.password = password;
        this.pin = pin;
    }
}
