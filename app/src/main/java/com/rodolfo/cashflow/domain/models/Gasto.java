package com.rodolfo.cashflow.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Gasto extends Transaccion{


    @Override
    public String getDetails() {
        return "";
    }
}
