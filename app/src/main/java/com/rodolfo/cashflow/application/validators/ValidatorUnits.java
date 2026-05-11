package com.rodolfo.cashflow.application.validators;

import java.util.function.Function;

public class ValidatorUnits {

    public static <T extends RuntimeException> void validarCampoObligatorio(
            String campo,
            String mensaje,
            Function<String, T> exceptionFactory
    ) {
        if (campo == null || campo.isBlank()) {
            throw exceptionFactory.apply(mensaje);
        }
    }

    public static <T extends RuntimeException> void validarNoNulo(
            Object valor,
            String mensaje,
            Function<String, T> exceptionFactory
    ) {
        if (valor == null) {
            throw exceptionFactory.apply(mensaje);
        }
    }

}
