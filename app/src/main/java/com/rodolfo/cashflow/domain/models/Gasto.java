package com.rodolfo.cashflow.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Gasto extends Transaccion{


    public Gasto (BigDecimal monto,
                          Long usuario_origen,
                          String descripcion) {

        super(monto, "GASTO", usuario_origen, null, "DEFECTO", descripcion);

    }

}
