package com.rodolfo.cashflow.domain.models;


import java.math.BigDecimal;
import java.net.IDN;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transferencia extends Transaccion{

    public Transferencia (BigDecimal monto,
                          Integer usuario_origen,
                          Integer usuario_destino,
                          String descripcion) {

        super(monto, "TRANSFERENCIA", usuario_origen, usuario_destino, null, descripcion);
    }

}
